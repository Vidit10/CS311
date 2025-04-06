	.data
a:
	10
	.text
main:
	load %x0, $a, %x3
	andi %x3, 2, %x4
	beq %x4, %x0, odd
	load %x0, 0, %x10
	subi %x0, 1, %x10
	end
odd:
	addi %x0, 1, %x10
	end
