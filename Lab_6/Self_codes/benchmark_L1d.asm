.data
a:
	70
	80
	40
	20
	10
	30
	50
	60
    39
    19
    77
n:
	11
	.text
main:
	load %x0, $n, %x3
    subi %x3, 1, %x3
outerwhile:
    beq %x3, %x0, terminate
    addi %x0, 0, %x4
innerwhile:
    beq %x4, %x3, restart
    addi %x4, 1, %x5
    load %x4, $a, %x6
    load %x5, $a, %x7
    bgt %x6, %x7, swap
    addi %x4, 1, %x4
    jmp innerwhile
restart:
    subi %x3, 1, %x3
    jmp outerwhile
swap:
    store %x6, 0, %x5
    store %x7, 0, %x4
    addi %x4, 1, %x4
    jmp innerwhile
terminate:
    end