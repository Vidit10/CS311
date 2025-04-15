    .data
a:
	40
	20
	.text
main:
    load %x0, $a, %x4
    addi %x0, 1, %x3
    load %x3, $a, %x5
    add %x4, %x5, %x6
    end