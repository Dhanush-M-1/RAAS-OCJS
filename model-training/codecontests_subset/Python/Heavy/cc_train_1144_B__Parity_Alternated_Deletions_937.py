# -*- coding: utf-8 -*-

from collections import deque
import sys

input = sys.stdin.readline

n: int = int(input())
a: [int] = sorted([int(x) for x in input().split()], reverse=True)

even, odd = deque(), deque()

for x in a:
    if x % 2 == 0:
        even.append(x)
    else:
        odd.append(x)

for _ in range(min(len(even), len(odd))):
    even.popleft()
    odd.popleft()

ans: int = 0

if len(even) > 0: even.popleft()
if len(odd) > 0: odd.popleft()

ans = sum(even) + sum(odd)

print(ans)

