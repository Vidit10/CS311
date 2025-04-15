    .data
    .text
main:
    addi %x0, 1, %x3
    addi %x0,  2, %x4
    addi %x0, 3, %x5
    addi %x0, 100, %x30
loop:
    add %x3, %x4, %x5
    add %x3, %x3, %x6
    add %x4, %x4, %x7
    add %x3, %x4, %x8
    add %x5, %x3, %x11
    add %x10, %x9, %x3
    add %x3, %x4, %x8
    add %x7, %x3, %x3
    add %x3, %x5, %x4
    add %x3, %x4, %x8
    add %x3, %x4, %x8
    add %x4, %x4, %x12
    add %x11, %x11, %x13
    add %x9, %x10, %x5
    add %x3, %x4, %x7
    add %x12, %x4, %x9
    add %x3, %x4, %x8
    add %x11, %x10, %x17
    add %x12, %x10, %x16
    add %x9, %x8, %x8
    add %x3, %x4, %x8
    add %x3, %x4, %x8
    add %x17, %x16, %x18
    add %x17, %x17, %x17
    subi %x30, 1, %x30
    bne %x30, 0, loop
    end