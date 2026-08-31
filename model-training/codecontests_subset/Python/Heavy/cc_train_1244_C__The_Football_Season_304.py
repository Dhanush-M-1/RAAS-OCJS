import math
import sys


def exgcd(a, b):
    if b == 0:
        return (1, 0)
    else:
        y, x = exgcd(b, a % b)
        y -= x * (a // b)
        return (x, y)


def ceil(x, y):
    return x // y + (x % y != 0)


def output(a, b, n):
    if a < 0 or b < 0:
        return
    if a + b > n:
        return

    print(a, b, n - a - b)
    sys.exit(0)


def main():
    n, p, w, d = [int(x) for x in input().split(' ')]
    g = math.gcd(w, d)
    if p % g != 0:
        print(-1)
        return
    x, y = exgcd(w, d)
    a = w // g
    b = d // g
    g = p // g
    x *= g
    y *= g

    if x < 0:
        t = ceil(-x, b)
        x += t * b
        y -= t * a
    elif y < 0:
        t = ceil(-y, a)
        x -= t * b
        y += t * a

    if x < 0 or y < 0:
        print(-1)
    else:
        output(x, y, n)
        output(x % b, y + (x // b) * a, n)
        output(x + (y // a) * b, y % a, n)
        print(-1)


if __name__ == '__main__':
    main()