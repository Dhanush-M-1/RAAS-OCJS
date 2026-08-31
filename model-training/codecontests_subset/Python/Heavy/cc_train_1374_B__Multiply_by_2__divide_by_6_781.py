from math import *


def pow3(n):
    c = 0
    while n > 0:
        if n % 3 == 0:
            c += 1
            n //= 3
        else:
            break
    return c


def pow2(n):
    if n & 1 == 1:
        return 0
    c = 0
    while n > 0:
        if n % 2 == 0:
            c += 1
            n //= 2
        else:
            break
    return c


def f(n):
    p3 = pow3(n)
    n //= 3**p3

    p2 = pow2(n)

    if p3 < p2:
        return -1

    n //= 2**p2

    if n == 1:
        return p3 + p3 - p2
    return -1


t = int(input())
for _ in range(t):
    n = int(input())
    print(f(n))
