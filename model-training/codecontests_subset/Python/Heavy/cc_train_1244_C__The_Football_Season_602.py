import sys


def gcd(a, b):
    # x1 * b + y1 (a % b) == d
    # x1 * b + y1 (a - (a // b)b) == d
    # x1 * b + y1 a - y1(a // b)b == d
    # b * (x1 - a // b * y1) + y1 a == d
    # y1 a + b * (x1 - a // b * y1) == d
    if b == 0:
        return (a, 1, 0)
    d, x, y = gcd(b, a % b)
    return (d, y, x - a // b * y)


def solve(n, p0, w0, d0):
    g, x, y = gcd(w0, d0)
    # print(g, x, y)
    if p0 % g != 0:
        print(-1)
        sys.exit()

    w = w0 // g; d = d0 // g; p = p0 // g

    assert(x * w + y * d == 1)
    x0, y0 = x * p, y * p
    assert(x0 * w + y0 * d == p)
    # print(x0, w, y0, d, p)

    delta = w - d
    mink = (x0 + y0 - n + delta - 1) // delta
    # print("mink = ", mink)
    mink = max(mink, (-x0 + d - 1) // d)
    # print("mink = ", mink)

    maxk = y0 // w
    # print("maxk = ", maxk)

    if mink > maxk:
        print(-1)
    else:
        k = mink
        x2 = x0 + k * d
        y2 = y0 - k * w
    #    print(x2, w, y2, d, p)
    #    exit()
        assert(x2 >= 0)
        assert(y2 >= 0)
        assert(x2 + y2 <= n)
        assert(x2 * w + y2 * d == p)
        assert(x2 * w0 + y2 * d0 == p0)
        print(x2, y2, n - (x2 + y2))

n, p0, w0, d0 = map(int, input().split())
solve(n, p0, w0, d0)

# for n in range(1, 101):
#     for p0 in range(0, 101):
#         for d0 in range(1, 101):
#             for w0 in range(d0 + 1, 101):
#                 solve(n, p0, d0, w0)
