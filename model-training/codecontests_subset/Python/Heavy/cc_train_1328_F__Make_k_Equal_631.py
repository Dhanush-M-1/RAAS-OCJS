import sys,math,itertools
from collections import Counter,deque,defaultdict
from bisect import bisect_left,bisect_right 
from heapq import heappop,heappush,heapify, nlargest
from copy import deepcopy
mod = 10**9+7
INF = float('inf')
def inp(): return int(sys.stdin.readline())
def inpl(): return list(map(int, sys.stdin.readline().split()))
def inpl_1(): return list(map(lambda x:int(x)-1, sys.stdin.readline().split()))
def err(x): print(x); exit()

n,k = inpl()
a = inpl(); a.sort()
c = Counter(a)
if max(c.values()) >= k: err(0)
aa = [0] + list(itertools.accumulate(a))
res = INF
for x in a:
    want = k - c[x]
    left_cnt = bisect_left(a,x)
    mi_cost = (x-1)*left_cnt-aa[left_cnt] 
    if left_cnt >= want:
        res = min(res, mi_cost+want)
    right_cnt = n-bisect_right(a,x)
    ma_cost = (aa[-1] - aa[-right_cnt-1]) - (x+1)*right_cnt
    if right_cnt >= want:
        res = min(res, ma_cost+want)
    res = min(res, mi_cost+ma_cost+want)
print(res)