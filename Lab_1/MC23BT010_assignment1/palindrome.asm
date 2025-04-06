	.data
a:
	10
	.text
main:
	add %x0, %x0, %x10
	load %x0, $a, %x4
	add %x4, %x0, %x5
	add %x0, %x0, %x6
loop:
	divi %x5, 10, %x5
	add %x6, %x31, %x6
	beq %x5, %x10, endl
	muli %x6, 10, %x6
	jmp loop
endl:
	beq %x6, %x4, yesDone
	bne %x6, %x4, noDone
yesDone:
	addi %x10, 1, %x10
	end
noDone:
	subi %x10, 1, %x10
	end
