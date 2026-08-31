from math import *

def inv(a, m):
    x = a % m
    b = 1
    while x != 1:
        x += a
        b += 1
        x %= m
    return b


n,p,w,d = map(int, input().split())
s = gcd(w,d)

if gcd(p, s) < s:
    print(-1)
    exit(0)

w,d,p = w // s, d // s, p // s

if d == 1:
    a = p // w
    b = p - (a*w)
else:
    b = ((p % w) * inv(d, w)) % w
    a = ((p % d) * inv(w, d)) % d

played = a + b
points = a * w + b * d
playedToo = (p - points) // w

if playedToo >= 0 and a + b + playedToo <= n:
    print(a + playedToo, b, n - (a+playedToo + b))
else:
    print(-1)
