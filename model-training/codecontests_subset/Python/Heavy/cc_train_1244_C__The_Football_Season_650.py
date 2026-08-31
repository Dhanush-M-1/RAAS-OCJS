import math
from decimal import *


def inv_mod(n, m):
    old_m = m
    nn = 1
    nm = 0
    mn = 0
    mm = 1
    while (m != 0):
        d = n // m
        n -= m * d
        nm -= mm * d
        nn -= mn * d
        n, m = m, n
        nm, mm = mm, nm
        nn, mn = mn, nn
    return ((nn % old_m + old_m) % old_m)


n, p, w, d = map(Decimal, input().split())
r = math.gcd(int(w), int(d))
if p % r != 0:
    print(-1)
else:
    p /= r
    w /= r
    d /= r
    y = (inv_mod(d, w) * (p % w)) % w
    x = (p - y * d) / w
    z = n - x - y
    if (x < 0 or y < 0 or z < 0):
        print(-1)
    else:
        print(int(x), int(y), int(z))
