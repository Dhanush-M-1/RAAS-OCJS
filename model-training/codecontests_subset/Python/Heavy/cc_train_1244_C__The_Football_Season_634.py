from math import ceil


def ex_gcd(a, b):
    # Base Case
    if a == 0:
        return b, 0, 1
    gcd, x1, y1 = ex_gcd(b % a, a)
    x = y1 - (b // a) * x1
    y = x1
    return gcd, x, y


n, p, w, d = map(int, input().split())
if p == 0:
    print(0, 0, n);
    exit(0)

g, _x, _y = ex_gcd(w, d)
_w = w // g
_d = d // g

if (p % g != 0 or (w * n) < p):
    print(-1)
    exit(0)

_x *= (p // g)

_y *= (p // g)

tl = ceil(-_x / _d)

tr = (_y // _w)

if tl > tr:
    print(-1)
    exit(0)

xx1 = _x + (_d * tl)
yy1 = _y - (_w * tl)
xx2 = _x + (_d * tr)
yy2 = _y - (_w * tr)

if xx1 + yy1 <= n:
    print(xx1, yy1, n - xx1 - yy1)
elif xx2 + yy2 <= n:
    print(xx2, yy2, n - xx2 - yy2)
else:
    print(-1)
