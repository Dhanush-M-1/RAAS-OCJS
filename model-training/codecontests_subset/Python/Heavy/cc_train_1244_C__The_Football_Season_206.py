"""
python3 C.py <<< "30 60 3 1"
"""

def GCD(a, b):
    while (a != 0 and b != 0):
        if (a > b):
            a %= b
        else:
            b %= a
    if a == 0:
        return b
    return a


def ExtendedGCD(a, b):
    s = 0
    old_s = 1
    r = b
    old_r = a

    while (r != 0):
        quotient = old_r // r

        tmp = old_r
        old_r = r
        r = tmp - quotient * r

        tmp = old_s
        old_s = s
        s = tmp - quotient * s

    if b != 0:
        bezout = (old_r - old_s * a) // b
    else:
        bezout = 0

    return [ old_r, old_s, bezout ]

def solve(n, p, w, d):
    gcdwd = GCD(w, d)
    if (p % gcdwd != 0):
        print(-1)
        return

    w0 = w // gcdwd
    d0 = d // gcdwd
    p0 = p // gcdwd

    A = ExtendedGCD(p0 * w0, p0 * d0)

    x0 = A[1] * p0
    y0 = A[2] * p0

    x = x0
    y = y0

    if (x < 0):
        j = (-x + d0 - 1) // d0
        x += j * d0
        y -= j * w0

    if (y < 0):
        j = (-y + w0 - 1) // w0
        y += j * w0
        x -= j * d0

    if (x < 0 or y < 0):
        print(-1)
        return

    if (y >= w0):
        j = y // w0
        x += j * d0
        y -= j * w0

    if (x + y > n):
        print(-1)
        return

    print(x, y, n - x - y)

n, p, w, d = map(int, input().split())

solve(n, p, w, d)
