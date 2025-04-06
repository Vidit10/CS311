	.data
a:
	10
	.text
main:
	load %x0, a, %x3
	divi %x3, 2, %x4
	beq %x31, 1, even
	beq %x31, 0, odd
odd:
	addi %x0, 1, %x10
	end
even:
	subi %x0, 1, %x10
	end
