import math
a,b = [int(x) for x in input().strip().split()]

def recur(can):
    if can<1:
        return can 
    else:
        return can + recur(can/b)

val = recur(a)
print(str(math.floor(val)))
