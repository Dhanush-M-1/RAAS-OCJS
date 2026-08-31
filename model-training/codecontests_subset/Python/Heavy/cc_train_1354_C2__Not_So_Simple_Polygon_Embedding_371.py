import sys
import math

for _ in range(int(input())):
    n = int(sys.stdin.readline())
    x = math.radians((180 - 360 / (2*n)) / 2)
    l = 1 / (math.cos(x))
    deg = 360 / (2*n)
    theta = math.radians(deg)

    d = 90
    m = 0
    for i in range(2*n):
        if deg*i < 90:
            d = 90 - deg*i
        else:
            m = i
            break

    lb, ub = math.radians(0), math.radians(d)
    ans = 1e9

    for _ in range(100):
        t = (ub + lb) / 2
        w, h = 0, 0
        for i in range(m):
            w = max(w, math.cos(t+i*theta)*l)
            h = max(h, math.sin(t+i*theta)*l)
        if w >= h:
            lb = t
        else:
            ub = t
        ans = min(ans, max(w, h))

    print(ans)
