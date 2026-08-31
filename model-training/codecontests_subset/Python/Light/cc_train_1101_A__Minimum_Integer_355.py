import math
q = int(input())

for i in range(q):
    l, r, d = map(int, input().split())
    n = l / d
    if n > 1:
        print(d)
    else:
        n = r / d
        print((math.floor(n) + 1) * d)
