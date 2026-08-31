import sys
import math,bisect
sys.setrecursionlimit(10 ** 5)
from itertools import groupby,accumulate
from heapq import heapify,heappop,heappush
from collections import deque,Counter,defaultdict
I = lambda : int(sys.stdin.readline())
neo = lambda : map(int, sys.stdin.readline().split())
Neo = lambda : list(map(int, sys.stdin.readline().split()))
for _ in range(I()):
    n = I()
    p = Neo()
    g = 1
    while g < n and p[g-1] == p[g]:
        g += 1
    s = g + 1
    while g + s < n and p[g+s-1] == p[g+s]:
        s += 1
    a = n//2
    while a > 0 and p[a-1] == p[a]:
        a -= 1
    b = a - g - s
    if b > g:
        print(g, s, b)
    else:
        print(0, 0, 0)