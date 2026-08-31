import sys


def gcd(a, b):
    if b == 0:
        return a
    else:
        return gcd(b, a % b)


def exgcd(a, b):
    if b == 0:
        return (1, 0)
    t = exgcd(b, a % b)
    x = t[1]
    y = t[0]
    y -= a // b * x
    return (x, y)


n, p, a, b = map(int, input().split())
G = gcd(a, b)
if p % G != 0:
    print("-1")
    sys.exit(0)
a //= G
b //= G
t = exgcd(a, b)
x = t[0]
y = t[1]
x *= p // G
y *= p // G
if y < 0:
    k = (-y - 1) // a + 1
    y += a * k
    x -= b * k
k = y // a
y -= a * k
x += b * k
if x * y < 0:
    print("-1")
    sys.exit(0)
if x + y <= n:
    print(x, y, n - x - y)
else:
    print("-1")