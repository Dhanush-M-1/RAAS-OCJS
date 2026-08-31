import sys,math,itertools
from collections import Counter,deque,defaultdict
from bisect import bisect_left,bisect_right 
from heapq import heappop,heappush,heapify
from copy import deepcopy,copy
mod = 10**9+7
INF = float('inf')
def inp(): return int(sys.stdin.readline())
def inpl(): return list(map(int, sys.stdin.readline().split()))
def inpl_1(): return list(map(lambda x:int(x)-1, sys.stdin.readline().split()))
def inps(): return sys.stdin.readline()
def inpsl(x): tmp = sys.stdin.readline(); return list(tmp[:x])
def err(x): print(x); exit()

MAX_A = 2*10**5+10
n,k = inpl()
a = inpl()
cost = [[] for _ in range(MAX_A+1)]
for x in a:
    now = x
    for i in range(1000):
        cost[now].append(i)
        now //= 2
        if now == 0: break
res = INF
for arr in cost:
    if len(arr) < k: continue
    arr.sort()
    res = min(res, sum(arr[:k]))
print(res)