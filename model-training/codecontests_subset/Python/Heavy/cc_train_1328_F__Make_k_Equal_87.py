# -*- coding: utf-8 -*-

import sys
import copy

sys.setrecursionlimit(1000000)

# input = sys.stdin.readline
# from collections import defaultdict
# import bisect

# ~~~~~~~~~~~~~~~~~~~~~_(＾～＾ ｣ ∠)_~~~~~~~~~~~~~~~~~~~~~


n, k = map(int, input().split())

a = list(map(int, input().split()))

B = [[] for i in range(200200)]

for i in range(n):
    cnt = 0
    while a[i] > 0:
        B[a[i]].append(cnt)
        cnt += 1
        a[i] //= 2
    B[a[i]].append(cnt)

ans = 1e20
for i in range(len(B)):
    if len(B[i]) >= k:
        B[i].sort()
        ans = min(ans, sum(B[i][0:k]))

print(ans)
