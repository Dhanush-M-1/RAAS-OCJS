#!/usr/bin/python3.6
import sys
input = sys.stdin.readline
from collections import Counter
import bisect

t = int(input())
for _ in range(t):
    n, m = map(int, input().split())
    a = [int(item) for item in input().split()]
    x = [int(item) for item in input().split()]
    cumsum = [0]
    cummax = [0]
    for item in a:
        cumsum.append(cumsum[-1] + item)
        cummax.append(max(cummax[-1], cumsum[-1]))
    diff = cumsum[-1]
    ans = []
    for item in x:
        ret = 0
        if diff <= 0 and item > cummax[-1]:
            ans.append(-1)
            continue
        if item > cummax[-1]:
            loop = ((item - cummax[-1] + diff - 1) // diff)
            ret += loop * n
            item -= diff * loop 
        ret += bisect.bisect_left(cummax, item) - 1
        ans.append(ret)
    print(*ans)