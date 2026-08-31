from fractions import gcd
from decimal import *
getcontext().prec = 10000
getcontext().rounding = ROUND_CEILING

def xgcd(a, b):
    """return (g, x, y) such that a*x + b*y = g = gcd(a, b)"""
    x0, x1, y0, y1 = 0, 1, 1, 0
    while a != 0:
        q, b, a = b // a, a, b % a
        y0, y1 = y1, y0 - q * y1
        x0, x1 = x1, x0 - q * x1
    return b, x0, y0

n, p, w, d = map(Decimal, input().split())
c = gcd(int(w), d)
if p == 0:
    print (0, 0, n)
elif p % c != 0:
    print (-1)
else:
    # Solve a * w + b * d = gcd(w, d)
    k = p // c
    _, a, b = xgcd(w, d)
    x1 = k * a
    y1 = k * b
    assert(x1 * w + y1 * d == p)
    f = True
    # print ("Bound: {} {}".format(int((-y1 / w * gcd(w, d)).to_integral_exact()), int(min(x1 * gcd(w, d) // d, (n - x1 - y1) * gcd(w, d) // (w - d)).to_integral_exact())))
    for r in range(int((-y1 / w * gcd(w, d)).to_integral_exact()), int(min(x1 * gcd(w, d) // d, (n - x1 - y1) * gcd(w, d) // (w - d)).to_integral_exact()) + 1):
        if f:
            x, y = x1 - r * (d // c), y1 + r * (w // c)
            z = n - x - y
            if x * w + y * d == p and x + y + z == n and x >= 0 and y >= 0 and z >= 0:
                print (x, y, z)
                f = False
        else:
            break
    if f:
        print (-1)