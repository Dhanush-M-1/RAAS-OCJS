def gcdx(a, b):
    if a == 0:
        return b, 0, 1
    if b == 0:
        return a, 1, 0
    g, x1,  y1 = gcdx(b, a % b)
    x = y1
    y = x1 - (a // b) * y1
    return g, x, y

def die():
    print(-1)
    exit()

def Ceil(x, y):
    return x // y + (1 if x % y != 0 else 0)

n, p, w, d = map(int, input().split())

g, x, y = gcdx(w, d)

if p % g != 0:
    die()

x *= p // g
y *= p // g

if (x < 0):
    step = Ceil(-x, d // g)
    x += step * (d // g)
    y -= step * (w // g)
if (y < 0):
    step = Ceil(-y, w // g)
    x -= step * (d // g)
    y += step * (w // g)
if (x < 0):
    die()

if (x + y <= n):
    print(x, y, n - x - y)
    exit(0)

step = y // (w // g)
x += step * (d // g)
y -= step * (w // g)

if (x + y > n):
    die()
print(x, y, n - x - y)


