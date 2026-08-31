def xgcd(a, b):
    """return (g, x, y) such that a*x + b*y = g = gcd(a, b)"""
    x0, x1, y0, y1 = 0, 1, 1, 0
    while a != 0:
        q, b, a = b // a, a, b % a
        y0, y1 = y1, y0 - q * y1
        x0, x1 = x1, x0 - q * x1
    return b, x0, y0


[n, p, w, d] = [int(x) for x in input().split(' ')]

nwd, _, _ = xgcd(w, d)

if p % nwd != 0:
    print(-1)
    exit(0)

a = w // nwd
b = d // nwd
c = p // nwd
_, x, y = xgcd(a, b)

x *= c
y *= c


def f(t):
    return 0 <= x + y + t * (a - b)


def bs(tb, te):
    while tb < te:
        t = (tb + te) // 2
        if not f(t):
            tb = t + 1
        else:
            te = t
    return tb

#
# k = bs((x + b - 1) // b, 0)
#
# nx = x - k * b
# ny = y + k * a

k = bs(-(y // a), x // b + 1)

nx = x - k * b
ny = y + k * a

for k in range(-10, 11):
    nnx = nx - k * b
    nny = ny + k * a
    if 0 <= nnx + nny <= n and nnx >= 0 and nny >= 0:
        print('{} {} {}'.format(nnx, nny, n - nnx - nny))
        exit(0)

print(-1)
