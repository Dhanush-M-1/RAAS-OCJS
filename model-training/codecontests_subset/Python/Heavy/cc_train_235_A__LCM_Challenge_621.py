#!/usr/bin/env python3
from sys import stdin, stdout


def solve(t):
    n = int(stdin.readline().strip())

    if n < 3:
        print(n)
        return

    if n % 2:
        print(n * (n - 1) * (n - 2))
    else:
        if n % 3 == 0:
            print((n - 1) * (n - 2) * (n - 3))
        else:
            print(n * (n - 1) * (n - 3))
    pass


LOCAL_TEST = not __debug__
if LOCAL_TEST:
    infile = __file__.split('.')[0] + '-test.in'
    stdin = open(infile, 'r')

tcs = (int(stdin.readline().strip()) if LOCAL_TEST else 1)
t = 1
while t <= tcs:
    solve(t)
    t += 1