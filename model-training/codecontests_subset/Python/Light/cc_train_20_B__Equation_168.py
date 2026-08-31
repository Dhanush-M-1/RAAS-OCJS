import math
a, b, c = map(int, input().split())
d = 0
if a == 0 and b == 0 and c == 0:
    print(-1)
    exit()
if a == 0 and b == 0:
    print(0)
    exit()
if a == 0:
    d -= c
    d /= b
    print(1)
    if d == -0:
        d = 0
    print(d)
    exit()
d = b * b - (4 * a * c)
if d < 0:
    print(0)
    exit()
if d == 0:
    print(1)
    d -= b
    d /= 2 * a
    print(d)
    exit()
if d > 0:
    print(2)
    q = -b + math.sqrt(d)
    q /= 2 * a
    w = -b - math.sqrt(d)
    w /= 2 * a
    if q > w:
        q, w = w, q
    print(q)
    print(w)
    exit()