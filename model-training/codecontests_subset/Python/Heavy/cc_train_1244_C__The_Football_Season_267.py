#!/usr/bin/python3

import array
from fractions import Fraction
import math
import os
import sys


def main():
    N, P, W, D = read_ints()
    ans = solve(N, P, W, D)
    if not ans:
        print('-1')
    else:
        print(*ans)


def gcd(a, b):
    if a < b:
        a, b = b, a
    while b > 0:
        a, b = b, a % b
    return a


def xgcd(a, b):
    if a < b:
        x, y = xgcd(b, a)
        return y, x
    if b == 0:
        return 1, 0
    y, x = xgcd(b, a % b)
    y -= a // b * x
    return x, y


def solve(N, P, W, D):
    if N * W < P:
        return None
    G = gcd(W, D)
    if P % G != 0:
        return None
    P //= G
    W //= G
    D //= G

    dprint("P W D:", P, W, D)

    x, y = xgcd(W, D)
    x *= P
    y *= P

    dprint("x y:", x, y)

    lb1 = Fraction(x + y - N, W - D)
    lb2 = Fraction(-x, D)
    mink = math.ceil(max(lb1, lb2))

    ub1 = Fraction(x + y, W - D)
    ub2 = Fraction(y, W)
    maxk = math.floor(min(ub1, ub2))

    dprint("lb1 lb2:", lb1, lb2, float(lb1), float(lb2))
    dprint("ub1 ub2:", ub1, ub2, float(ub1), float(ub2))
    dprint("mink maxk:", mink, maxk)

    if not (mink <= maxk):
        return None

    k = mink
    xx = x + k * D
    yy = y - k * W
    zz = N - xx - yy
    dprint(xx, yy, zz)
    assert zz >= 0
    assert xx * W + yy * D == P
    assert xx >= 0
    assert yy >= 0
    return xx, yy, zz


DEBUG = 'DEBUG' in os.environ


def inp():
    return sys.stdin.readline().rstrip()


def read_int():
    return int(inp())


def read_ints():
    return [int(e) for e in inp().split()]


def dprint(*value, sep=' ', end='\n'):
    if DEBUG:
        print(*value, sep=sep, end=end)


if __name__ == '__main__':
    main()
