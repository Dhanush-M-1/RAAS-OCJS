import sys,os,io
import math,bisect,operator
inf,mod = float('inf'),10**9+7
# sys.setrecursionlimit(10 ** 6)
from itertools import groupby,accumulate
from heapq import heapify,heappop,heappush
from collections import deque,Counter,defaultdict
input = iter(sys.stdin.buffer.read().decode().splitlines()).__next__
Neo = lambda : list(map(int,input().split()))
# test, = Neo()
n,k = Neo()
A = Neo()
c = []
d = [[0,c.copy()] for i in range(max(A)+1)]
Ans = inf
for i in A:
    t = 0
    while True:
        d[i][0] += 1
        d[i][1].append(t)
        if i == 0:
            break
        t += 1
        i = i//2
for i,j in d:
    if i >= k:
        Ans = min(Ans,sum(sorted(j)[:k]))
print(Ans)        
        
        
