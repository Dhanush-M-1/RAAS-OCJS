#!/usr/bin/env python3
import sys
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    n, m = [int(item) for item in input().split()]
    command = input().rstrip()
    tries = [int(item) for item in input().split()] + [n]
    cumsum = [0] * (n + 1)
    for item in tries:
        cumsum[0] += 1
        cumsum[item] -= 1
    for i in range(n):
        cumsum[i+1] += cumsum[i] 
    ans = [0] * 26
    orda = ord("a")
    for ch, cnt in zip(command, cumsum):
        ans[ord(ch) - orda] += cnt
    print(*ans)