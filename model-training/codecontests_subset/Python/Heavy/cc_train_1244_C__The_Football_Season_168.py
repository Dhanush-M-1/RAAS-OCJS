import math
from decimal import Decimal
n, p, w, d = [Decimal(x) for x in input().split()]


def gcd(x, y):
    while y % x != 0:
        return gcd(y % x, x)
    else:
        return x


def ext_euclid(a, b):
    if b == 0:
        return 1, 0, a
    else:
        x, y, q = ext_euclid(b, a % b)  # q = gcd(a, b) = gcd(b, a%b)
        x, y = y, (x - (a // b) * y)
        return x, y, q


if p/w > n and p/d > 0:
    print(-1)
    exit(0)

m = gcd(w, d)

if p % m != 0:
    print(-1)
else:
    w /= m
    d /= m
    p /= m
    x, y, q = ext_euclid(w, d)

    # get x0 and y0
    x *= p
    y *= p

    l = int(math.ceil(-x/d))
    r = int((n-x)//d)

    l0 = int(math.ceil((y-n)/w))
    r0 = int(math.floor(y/w))

    l = max(l, l0)
    r = min(r, r0)

    while l <= r:
        i = l + (r-l)//2
        xt = x+i*d
        yt = y-i*w
        if xt + yt <= n:
            print(int(xt), int(yt), int(n-xt-yt))
            exit(0)
        else:
            if w > d:
                l = i+1
            else:
                r = i-1

    print(-1)
