def gcd(a, b):
    if b == 0:
        return a, 1, 1
    else:
        g, x1, y1 = gcd(b, a % b)
        return g, y1, x1 - a // b * y1


n, c, a, b = map(int, input().split())
g = gcd(a, b)[0]
if c % g:
    print('-1')
else:
    a //= g
    b //= g
    c //= g
    _, x, y = gcd(a, b)
    x *= c
    y *= c
    k1 = - x // b
    if x + k1 * b < 0:
        k1 += 1
    k2 = y // a
    if y - k2 * a < 0:
        k2 += 1
    k3 = (x + y - n) // (a - b)
    if x + y - k3 * (a - b) < n:
        k3 += 1
    if max(k1, k3) > k2:
        print(-1)
    else:
        k = k2
        print(x + k * b, y - k * a, n - x - k * b - y + k * a)
