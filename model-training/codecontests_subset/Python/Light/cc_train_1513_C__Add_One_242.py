import sys,os,io
import math,bisect,operator
inf,mod = float('inf'),10**9+7
# sys.setrecursionlimit(10 ** 6)
from itertools import groupby,accumulate
from heapq import heapify,heappop,heappush
from collections import deque,Counter,defaultdict
input = iter(sys.stdin.buffer.read().decode().splitlines()).__next__
Neo = lambda : list(map(int,input().split()))
test, = Neo()
dp=[]
M=10**9+7
for i in range(200011):
    if i<10:
        dp.append(1)
    else:
        dp.append((dp[i-9]+dp[i-10])%M)
for _ in range(test):
    n,m = Neo()
    n = str(n)
    ans=0
    for i in n:
        ans=(ans+dp[m+int(i)])%M
    print(ans)