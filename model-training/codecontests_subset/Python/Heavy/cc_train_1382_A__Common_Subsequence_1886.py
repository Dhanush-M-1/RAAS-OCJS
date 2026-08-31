#!/usr/bin/env python3
import os
from sys import stdin, stdout


def solve(tc):
    n, m = map(int, stdin.readline().split())
    sa = list(map(int, stdin.readline().split()))
    sb = list(map(int, stdin.readline().split()))

    mapA = [False for i in range(1001)]
    for i in range(n):
        mapA[sa[i]] = True

    for i in range(m):
        if mapA[sb[i]]:
            print("YES")
            print(1, sb[i])
            return

    print("NO")


tcs = 1
tcs = int(stdin.readline().strip())
tc = 1
while tc <= tcs:
    solve(tc)
    tc += 1
