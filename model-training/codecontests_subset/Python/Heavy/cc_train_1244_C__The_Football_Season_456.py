from sys import stdin
from math import ceil, floor


def extgcd(a, b):
    if a == 0:
        return (b, 0, 1)
    g, x1, y1 = extgcd(b % a, a)
    x = y1 - (b // a) * x1
    y = x1
    return (g, x, y)


# n, p, w, d = map(int, raw_input().split())
n, p, w, d = map(int, stdin.readline().split())
# print(n, p, w, d)
g, x0, y0 = extgcd(w, d)
# print(type(g))
# print(type(x0))
# print(type(y0))
ans = True
if p % g != 0:
    ans = False
else:
    x0 *= p//g
    y0 *= p//g
    # print(type(x0))
    # print(type(y0))
    # x=x0+k*d/g
    # x0+k*d/g>=0
    # k>=-x0*g/d
    # x0+k*d/g<=n
    # k<=(n-x0)*g/d
    # y=y0-k*w/g
    # y0-k*w/g>=0, k<=y0*g/w
    # y0-k*w/g<=n, k>=(y0-n)*g/w
    klb = int(max(ceil(-x0*g/d), ceil((y0-n)*g/w)))
    kub = int(min(floor((n-x0)*g/d), floor(y0*g/w)))
    if d > w:
        kub = min(kub, int(floor(g*(n-x0-y0)/(d-w))))
    elif d < w:
        klb = max(klb, int(ceil(g*(n-x0-y0)/(d-w))))
    else:
        pass
    if klb > kub:
        ans = False
    else:
        k = klb
        z = -1
        while k <= kub and (z < 0 or z > n):
            x = x0+k*d//g
            y = y0-k*w//g
            z = n-x-y
            # print("%s %s %s" % (x, y, z))
            k += 1
        if z < 0 or z > n:
            ans = False
if ans:
    print("%s %s %s" % (x, y, z))
else:
    print("-1")
