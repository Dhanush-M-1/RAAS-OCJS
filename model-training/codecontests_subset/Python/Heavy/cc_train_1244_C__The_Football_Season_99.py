from __future__ import division
from math import *

x, y = 0, 0


def abs(x):
    return x if x > 0 else -x


def gcd(a, b):
    return gcd(b, a % b) if b else a


def exgcd(a, b):
    global x, y
    if b == 0:
        x, y = 1, 0
    else:
        exgcd(b, a % b)
        x, y = y, x
        y -= a // b * x


def mle(a, b, n, tot):
    global x, y
    a, b = b, a
    d = gcd(a, b)
    if n % d != 0:
        return False
    n //= d
    a //= d
    b //= d
    i = b
    exgcd(a, b)
    # print("a,b,n,x,y=", a, b, n, x, y)
    x *= n
    e = abs(x) // i
    if x < 0:
        x += e * i
        x += i if x < 0 else 0
    else:
        x -= e * i
    aa = x
    bb = (n - a * aa) // b
    cc = tot - aa - bb
    if aa < 0 or bb < 0 or cc < 0 or aa * a + bb * b != n:
        return False
    print(bb, aa, cc)
    return True


# with open("data.in", 'r') as f:
# for line in f:
n, p, d, w = map(int, input().strip().split())
# n, p, d, w = map(int, line.strip().split())
if not mle(d, w, p, n):
    print(-1)
