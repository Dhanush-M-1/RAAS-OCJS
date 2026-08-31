def exgcd(a, b):
    if b == 0:
        x = 1
        y = 0
        return a, x, y
    d, y, x = exgcd(b, a % b)
    y -= a // b * x
    return d, x, y

n, p, w, d = map(int, input().split())
g, x, y = exgcd(w, d)
if p % g != 0:
    print(-1)
    exit(0)
x *= (p // g)
y *= (p // g)
t = (y % (w // g) + (w // g)) % (w // g)
k = (y - t) // (w // g)
X = x + k * (d // g)
Y = y - k * (w // g)
if X < 0:
    t = (x % (d // g) + (d // g)) % (d // g)
    k = (x - t) // (d // g)
X = x + k * (d // g)
Y = y - k * (w // g)

if X >= 0 and Y >= 0 and X + Y <= n:
    print(X, Y, n - X - Y)
else:
    print(-1)