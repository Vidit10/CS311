	.data
a:
	10
	.text
main:
	load %x0, $a, %x3
	addi %x0, 2, %x4
	blt %x3, 2, noPrime
	beq %x3, %x4, yesPrime
loop:
	div %x3, %x4, %x5
	beq %x0, %x31, noPrime
	addi %x4, 1, %x4
	beq %x4, %x3, yesPrime
	bne %x4, %x3, loop
yesPrime:
	addi %x0, 1, %x10
	end
noPrime:
	subi %x0, 1, %x10
	end
