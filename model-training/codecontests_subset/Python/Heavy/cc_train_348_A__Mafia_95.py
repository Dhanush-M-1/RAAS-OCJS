#!/usr/bin/env python3
import os
from sys import stdin


def solve(tc):
    N = int(stdin.readline().strip())
    seq = list(map(int, stdin.readline().split()))

    low, high = max(seq), int(1e15)+1
    while low < high:
        mid = low + (high-low)//2

        mafiaCnt = 0
        for i in range(N):
            if seq[i] < mid:
                mafiaCnt += mid - seq[i]

        if mafiaCnt < mid:
            low = mid + 1
        else:
            high = mid

    print(low)


tcs = 1
# tcs = int(stdin.readline().strip())
tc = 1
while tc <= tcs:
    solve(tc)
    tc += 1
