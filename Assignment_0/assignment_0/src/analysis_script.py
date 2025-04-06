import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns
import numpy as np

# Read the simulation data
df = pd.read_csv('simulation_results.csv')

# Calculate success rate and average crossing time for each p and W combination
analysis = df.groupby(['probability', 'width']).agg({
    'succeeded': 'mean',  # Success rate
    'time': lambda x: x[df['succeeded']].mean()  # Average time for successful crossings
}).reset_index()

# Create success rate heatmap
plt.figure(figsize=(12, 8))
success_pivot = analysis.pivot(index='probability', columns='width', values='succeeded')
sns.heatmap(success_pivot, annot=True, fmt='.2f', cmap='YlOrRd')
plt.title('Success Rate by Probability and Width')
plt.xlabel('Border Width (W)')
plt.ylabel('Sensor Activation Probability (p)')
plt.tight_layout()
plt.savefig('success_rate_heatmap.png')
plt.close()

# Create average crossing time heatmap
plt.figure(figsize=(12, 8))
time_pivot = analysis.pivot(index='probability', columns='width', values='time')
sns.heatmap(time_pivot, annot=True, fmt='.0f', cmap='viridis')
plt.title('Average Crossing Time (Successful Attempts Only)')
plt.xlabel('Border Width (W)')
plt.ylabel('Sensor Activation Probability (p)')
plt.tight_layout()
plt.savefig('crossing_time_heatmap.png')
plt.close()

# Create line plots for different widths
plt.figure(figsize=(12, 6))
for w in sorted(df['width'].unique()):
    subset = analysis[analysis['width'] == w]
    plt.plot(subset['probability'], subset['succeeded'], 
             marker='o', label=f'W={w}')
plt.xlabel('Sensor Activation Probability (p)')
plt.ylabel('Success Rate')
plt.title('Success Rate vs. Probability for Different Border Widths')
plt.legend()
plt.grid(True)
plt.tight_layout()
plt.savefig('success_rate_by_width.png')
plt.close()
