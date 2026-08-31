def gcd(a, b):
    if (a == 0):
        return (b, 0, 1)

    d, x1, y1 = gcd(b % a, a)

    return (d, y1 - (b // a) * x1, x1)


SuperINF = 2 * 100000000000000

n, p, w, d = map(int, input().split())

NOD, x, y = gcd(d, w)
if (p % NOD != 0):
    print(-1)
else:
    d //= NOD
    w //= NOD
    p //= NOD

    x, y = x * p, y * p

    ost = (x + SuperINF * w) % w

    x = ost

    y = (p * NOD - x * NOD * d) // (NOD * w)

    if (y < 0):
        print(-1)
    elif (x + y > n):
        print(-1)
    else:
        ans1 = y
        ans2 = x
        ans3 = n - x - y
        print(ans1, ans2, ans3)