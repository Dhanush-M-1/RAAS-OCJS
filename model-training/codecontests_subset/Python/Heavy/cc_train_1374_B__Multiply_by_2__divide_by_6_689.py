from math import *
from itertools import *
from collections import *


def ii():
    return int(input())


def mas():
    return [int(i) for i in input().split()]


def mapis():
    return map(int, input().split())


INF = 1e9 + 1


def solve():
    n = ii()

    d = 0

    for i in range(0, 10 ** 2):
        if n == 1:
            print(i)
            break

        if n % 6 == 0:
            n //= 6
        else:
            n *= 2

    if n != 1:
        print(-1)


def main():
    # t = 1
    t = ii()

    while t:
        solve()

        t -= 1


main()
