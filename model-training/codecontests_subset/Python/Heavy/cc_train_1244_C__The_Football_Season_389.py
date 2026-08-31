def gcd(a, b):
    if a == 0:
        return b, 0, 1
    d, x1, y1 = gcd(b % a, a)
    x = y1 - (b // a) * x1
    y = x1
    return d, x, y


def find_any(a, b, c):
    g, x, y = gcd(abs(a), abs(b))
    assert c % g == 0
    x *= c // g
    y *= c // g
    if a < 0:
        x *= -1
    if b < 0:
        y *= -1
    return g, x, y


def main():
    n, p, w, d = map(int, input().split())
    try:
        g, x, y = find_any(w, d, p)
    except AssertionError:
        print(-1)
        return

    # x + y <= n, x >= 0, y >= 0
    mnk = ((-x) * g + d - 1) // d
    mxk = y * g // w
    if mnk > mxk:
        print(-1)
        return

    def getsum(k):
        nonlocal x, y, w, d, g
        nx = x + d // g * k
        ny = y - w // g * k
        return nx + ny

    l = mnk
    r = mxk
    while r - l > 2:
        m1 = (l * 2 + r) // 3
        m2 = (l + r * 2) // 3
        if getsum(m1) > getsum(m2):
            l = m1
        else:
            r = m2

    best_k = -1
    best_sum = 10 ** 18
    for k in range(l, r + 1):
        sm = getsum(k)
        if sm < best_sum:
            best_sum = sm
            best_k = k

    nx = x + d // g * best_k
    ny = y - w // g * best_k
    if nx + ny <= n:
        print(nx, ny, n - nx - ny)
    else:
        print(-1)

main()
