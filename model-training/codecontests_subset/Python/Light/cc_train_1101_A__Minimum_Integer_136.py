import math
n = int(input())
for i in range(n):
    l, r, d = map(int,input().split())
    if d<l:
        print(d)
    else:
        b = math.ceil(r/d)
        if r % d == 0:
            b += 1
        print(int(b*d))