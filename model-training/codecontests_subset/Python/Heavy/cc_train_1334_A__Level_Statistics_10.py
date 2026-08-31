import sys
import heapq
import re
from itertools import permutations
from bisect import bisect_left, bisect_right
from collections import Counter, deque
from fractions import gcd
from math import factorial, sqrt, ceil
from functools import lru_cache, reduce
INF = 1 << 60
MOD = 1000000007
sys.setrecursionlimit(10 ** 7)

# ここから書き始める
t = int(input())
for i in range(t):
    n = int(input())
    p = [0 for i in range(n)]
    c = [0 for i in range(n)]
    yes = True
    for j in range(n):
        p[j], c[j] = map(int, input().split())
        if p[j] < c[j]:
            yes = False
        if j > 0:
            if p[j] < p[j - 1] or c[j] < c[j - 1] or p[j] - p[j - 1] < c[j] - c[j - 1]:
                yes = False
    if yes:
        print("YES") 
    else:
        print("NO")
        
