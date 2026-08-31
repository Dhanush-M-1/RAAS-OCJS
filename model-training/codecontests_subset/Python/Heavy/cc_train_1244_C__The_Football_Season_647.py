def gcd(a, b):
    if a == 0:
        return (b, 0, 1)
    d, x1, y1 = gcd(b%a, a)
    x = y1 - (b // a) * x1
    y = x1
    return (d, x, y)

import math

def fas(a, b, c):
    g, x, y = gcd(abs(a), abs(b))
    if c % g != 0:
        return (False, 0, 0, g)
    x *= c // g
    y *= c // g
    if (a < 0):
        x *= -1
    if (b < 0):
        y *= -1
    return (True, x, y, g)

n, p, w, d = map(int, input().split())

can, x, y, g  = fas(w, d, p)

if can == False:
    print(-1)
    exit(0)

w //= g
d //= g

if (y > x):
    cnt = y // w
    #print(cnt)
    y -= cnt * w
    x += cnt * d

#print(x, y)

if (y < 0):
    cnt = -y // w
    if y % w != 0:
        cnt += 1
    cnt = -cnt
    #print(cnt)
    y -= cnt * w
    x += cnt * d

#print(x, y)

if (x + y <= n and x >= 0 and y >= 0):
    print(x, y, n - x - y)
else:
    print(-1)
