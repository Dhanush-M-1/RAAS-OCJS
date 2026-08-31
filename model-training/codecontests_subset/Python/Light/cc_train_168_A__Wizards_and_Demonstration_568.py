import math

S = input().split()

n = int(S[0])
x = int(S[1])
y = int(S[2])

needed = math.ceil(y/100*n)

if needed-x > 0:
    print(needed-x)
else:
    print(0)

