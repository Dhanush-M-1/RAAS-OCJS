import math


A, B, C = map(int, input().split())

if A < 0:
    A, B, C = -A, -B, -C

if A != 0:
    some_num = B * B / (4 * A) - C

if A == 0:
    if B == 0 and C == 0:
        print(-1)
    elif B != 0:
        print(1)
        print(-C / B)
    else:
        print(0)
elif some_num > 0:
    print(2)
    print((-math.sqrt(some_num) - B / (2 * math.sqrt(A))) / math.sqrt(A))
    print((math.sqrt(some_num) - B / (2 * math.sqrt(A))) / math.sqrt(A))
elif -1e-8 < some_num < 1e-8:
    print(1)
    print(-B / (2 * A))
else:
    print(0)
