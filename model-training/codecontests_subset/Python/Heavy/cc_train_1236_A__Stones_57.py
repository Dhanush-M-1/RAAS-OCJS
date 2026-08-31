import sys,math,itertools
from collections import Counter,deque,defaultdict
from bisect import bisect_left,bisect_right 
from heapq import heappop,heappush,heapify
mod = 10**9+7
INF = float('inf')
def inp(): return int(sys.stdin.readline())
def inpl(): return list(map(int, sys.stdin.readline().split()))

for _ in range(inp()):
    a,b,c = inpl()
    res = 0
    while b > 0 and c > 1:
        b -= 1; c -= 2
        res += 3
    while a > 0 and b > 1:
        a -= 1; b-= 2
        res += 3
    print(res)
