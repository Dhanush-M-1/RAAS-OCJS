n, p, w, d = map(int, input().split())
def exgcd(a, b, xy):
    if (b == 0):
        xy[0] = 1
        xy[1] = 0
        return a
    r = exgcd(b, a % b, xy)
    tmp = xy[1]
    xy[1] = xy[0] - (a//b) * xy[1]
    xy[0] = tmp
    return r
xy = [0, 0]
g = exgcd(w, d, xy)
x = xy[0]
y = xy[1]
if (p % g != 0):
    print(-1)
    exit(0)
k = p // g
x *= k; y *= k
d //= g; w //= g
if (x < 0) :
    k = (-x + d - 1) // d
    x += k * d; y -= k * w;
elif (y < 0) :
    k = (-y + w - 1) // w
    x -= k * d; y += k * w;
if (x < 0 or y < 0):
    print(-1)
    exit(0)
k = y // w; x += k * d; y -= k * w;
if (x + y > n):
    print(-1)
    exit(0)
print(int(x), int(y), int(n - x - y))
