in0, in1 = [int(x) for x in input().split()]
in2, in3 = in0, 0
while in0 != 0:
    in3 = in0 % in1
    in0 //= in1
    in2 += in0
    if in0 > 0:
        in0 += in3
print(in2)