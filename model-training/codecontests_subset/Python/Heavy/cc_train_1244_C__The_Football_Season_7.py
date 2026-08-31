def xgcd(a, b):
    """return (g, x, y) such that a*x + b*y = g = gcd(a, b)"""
    x0, x1, y0, y1 = 0, 1, 1, 0
    while a != 0:
        q, b, a = b // a, a, b % a
        y0, y1 = y1, y0 - q * y1
        x0, x1 = x1, x0 - q * x1
    return b, x0, y0


def main():
    n, p, w, d = map(int, input().split(" "))
    ok = 1

    g, x, y = xgcd(w,d)
    if (p % g != 0): ok = 0
    
    x *= p // g
    y *= p // g
    c1 = w // g
    c2 = d // g

    if y < 0:
        k = -1*y // c1;
        if (-1*y % c1 != 0): k += 1
        y += k*c1
        x -= k*c2

    if y >= c1:
        k = y // c1;
        y -= k*c1
        x += k*c2

    if x < 0 or y < 0 or (x+y)>n: ok =0
    if not ok:
        print(-1)
        return

    rem = n - x - y
    print("{0} {1} {2}".format(x, y, rem))

if __name__ == "__main__":
    main()

