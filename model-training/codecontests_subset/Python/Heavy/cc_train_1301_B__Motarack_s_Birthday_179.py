#!/usr/bin/env python3
import sys
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    n = int(input())
    a = [int(item) for item in input().split()]
    max_val = 0
    min_val = 10**12
    max_diff = 0
    for a1, a2 in zip(a, a[1:]):
        if a1 == -1:
            if a2 == -1:
                continue
            else:
                max_val = max(max_val, a2)
                min_val = min(min_val, a2)
        else:
            if a2 == -1:
                max_val = max(max_val, a1)
                min_val = min(min_val, a1)
            else:
                max_diff = max(max_diff, abs(a1 - a2))
    k = (max_val + min_val) // 2
    if min_val == 10**12:
        k = 0
    m = max(max_diff, max_val - k, k - min_val)
    print(m, k)