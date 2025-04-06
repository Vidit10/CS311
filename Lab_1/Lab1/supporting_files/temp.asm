	.data
a:
	2
	7
	4
	67
	669
num:
	89
	.text
main:
	load %x0, $a, %x3
	load %x0, $a, %x4
	addi %x4, 1, %x4
	addi %x8, 3, %x8
	addi %x9, 1, %x9
	store %x9, $num, %x8
	end
