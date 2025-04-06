	.data
a:
	20
	10
	65
	89
	21
n:
	5
	.text
main:
	load %x0, $n, %x3
	@ load %x0, $n, %x9
	jmp outer_loop
outer_loop:
	blt %x4, %x3, inner_loop
	end
inner_loop:
	blt %x5, %x3, check_value
	addi %x4, 1, %x4
	jmp outer_loop
check_value:
	load %x4, $a, %x6
	load %x5, $a, %x7
	blt %x7, %x6, swap
	addi %x5, 1, %x5
	jmp inner_loop
swap:
	store %x6, $a, %x4
	store %x7, $a, %x5
	addi %x5, 1, %x5
	jmp check_value
