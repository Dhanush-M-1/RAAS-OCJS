def gcd(a, b):
    while a:
        time = a
        a = b % a
        b = time
    return b


def ful_gcd(a, b):
    if a == 0:
        return b, 0, 1
    d, x0, y0 = ful_gcd(b % a, a)
    x = y0 - (b // a) * x0
    y = x0
    return d, x, y


def main():
    n, c, a, b = map(int, input().split())
    d = gcd(a, b)
    if c % d != 0:
        print(-1)
        return
    a //= d
    b //= d
    c //= d
    _d, x0, y0 = ful_gcd(a, b)
    x1 = c * x0
    y1 = c * y0
    max_k = y1 // a
    x = x1 + max_k * b
    y = y1 - max_k * a
    z = n - x - y
    if (x < 0) or (y < 0) or (z < 0):
        print(-1)
    else:
        print(x, y, z)


main()
