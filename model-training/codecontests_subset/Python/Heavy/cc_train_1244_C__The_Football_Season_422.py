def exgcd(a, b):
    if b == 0:
        return a, 1, 0
    d, x, y = exgcd(b, a % b)
    t = x
    x = y
    y = t - (a // b) * y
    return d, x, y


n, p, w, d = map(int, input().split())
g, x, y = exgcd(w, d)
if p % g != 0:
    print(-1)
else:
    x *= p // g
    y *= p // g
    w //= g
    d //= g
    if x < 0:
        t = (-x + d - 1) // d
        x += t * d
        y -= t * w
    if y < 0:
        t = (-y + w - 1) // w
        x -= t * d
        y += t * w
    if x < 0 or y < 0:
        print(-1)
    else:
        t = y // w
        x += t * d
        y -= t * w
        if x + y <= n:
            print(x, y, n - x - y)
        else:
            print(-1)
