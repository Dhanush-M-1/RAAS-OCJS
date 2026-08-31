#!/usr/bin/env python3
import sys
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    n = int(input())
    a = [int(item) for item in input().split()]
    if a[0] + a[1] <= a[-1]:
        print(1, 2, n)
    else:
        print(-1)