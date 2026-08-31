import sys
import math,bisect
sys.setrecursionlimit(10 ** 5)
from itertools import groupby,accumulate
from heapq import heapify,heappop,heappush
from collections import deque,Counter,defaultdict
def I(): return int(sys.stdin.readline())
def neo(): return map(int, sys.stdin.readline().split())
def Neo(): return list(map(int, sys.stdin.readline().split()))
mod = 998244353
fact = [1]
for i in range(1,4*10**5):
    fact.append(fact[-1]*i%mod)
n,k = neo()
s,e = [],[]
for _ in range(n):
    l,r = neo()
    s.append(l)
    e.append(r)
s.sort()
e.sort()
#print(s,e)
Ans = 0
for i in range(n):
    p = bisect.bisect_right(s,e[i])-i
    if p >= k:
        Ans += fact[p-1]*pow((fact[k-1]*fact[p-k])%mod,mod-2,mod)
        Ans %= mod
print(Ans)
