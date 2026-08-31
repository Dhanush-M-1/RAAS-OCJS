def gcd(a, b):
    if a == 0 :
        return (b, 0, 1)
    g, x, y = gcd(b % a, a)
    return (g, y - b // a * x, x)

n, c, a, b = map(int, input().split())

g, x, y = gcd(a, b)
if c % g != 0:
    print(-1)
    exit(0)
a //= g
b //= g
c //= g
x *= c
y *= c
def go(x, y, a, b, t):
    x = x + b * t
    y = y - a * t
    return (x, y)
x, y = go(x, y, a, b, -x // b)
if x < 0:
    x, y = go(x, y, a, b, 1)
x, y = go(x, y, a, b, y // a)
while y < 0:
    x, y = go(x, y, a, b, 1)
if x + y <= n and x >= 0 and y >= 0:
    print(x, y, n - x - y)
else:
    print(-1)