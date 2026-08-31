import math
import sys


def gcd(a, b):
    if a == 0:
        return 0, 1, b
    x1, y1, d = gcd(b % a, a)
    x = y1 - (b // a) * x1
    y = x1
    return x, y, d


def findSol(a, b, c):
    x0, y0, g = gcd(a, b)
    if c % g != 0:
        return None, None, None
    x0 *= c // g
    y0 *= c // g
    return x0, y0, g


def outSolution(x, y, n):
    print(x, y, n - x - y)


def check(x, y, n, p, w, d):
    if x > n or y > n:
        return False
    return x * w + y * d == p and x + y <= n


def shiftRight(x, y, a, b, g):
    cnt = y // a
    y -= cnt * a
    x += cnt * b
    return x, y


def shiftLeft(x, y, a, b, g):
    cnt = x // b
    y += cnt * a
    x -= cnt * b
    return x, y

def main():
    n, p, w, d = [int(x) for x in input().split(' ')]
    g = math.gcd(w, d)
    if p % g != 0:
        print(-1)
        return

    x0, y0, g = findSol(w, d, p)
    if x0 is None:
        print(-1)
        return
    a = w // g
    b = d // g

    if x0 < 0:
        cnt = abs(x0) // b
        x0 += cnt * b
        y0 -= cnt * a
        while x0 < 0:
            x0 += b
            y0 -= a

        if y0 < 0:
            print(-1)
            return
    elif y0 < 0:
        cnt = abs(y0) // a
        x0 -= cnt * b
        y0 += cnt * a
        while y0 < 0:
            x0 -= b
            y0 += a
        if x0 < 0:
            print(-1)
            return

    if check(x0, y0, n, p, w, d):
        outSolution(x0, y0, n)
        return

    x0, y0 = shiftRight(x0, y0, a, b, g)
    if check(x0, y0, n, p, w, d):
        outSolution(x0, y0, n)
        return
    x0, y0 = shiftLeft(x0, y0, a, b, g)
    if check(x0, y0, n, p, w, d):
        outSolution(x0, y0, n)
        return

    print(-1)


if __name__ == '__main__':
    main()
