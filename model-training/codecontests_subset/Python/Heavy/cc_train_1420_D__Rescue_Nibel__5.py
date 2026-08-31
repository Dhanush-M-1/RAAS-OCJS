import sys, math
import io, os
#data = io.BytesIO(os.read(0,os.fstat(0).st_size)).readline
from bisect import bisect_left as bl, bisect_right as br, insort
from heapq import heapify, heappush, heappop
from collections import defaultdict as dd, deque, Counter
# from itertools import permutations,combinations
def data(): return sys.stdin.readline().strip()
def mdata(): return list(map(int, data().split()))
def outl(var): sys.stdout.write('\n'.join(map(str, var)) + '\n')
def out(var): sys.stdout.write(str(var) + '\n')
from decimal import Decimal
# from fractions import Fraction
# sys.setrecursionlimit(100000)
mod = 998244353
INF=float('inf')


def modularInverse_n(n):
    finv = [0] * (n + 1)
    finv[-1]=pow(f[n],mod-2,mod)
    for i in range(n-1,-1,-1):
        finv[i] = (finv[i+1]*(i+1))%mod
    return finv


n,k=mdata()
q=sorted([mdata() for i in range(n)],key=lambda x:x[0])
if k==1:
    out(n)
    exit()
lis=[]
f=[1]
for i in range(1,n+1):
    f.append((i*f[-1])%mod)
finv = [0] * (n + 1)
finv[-1]=pow(f[n],mod-2,mod)
for i in range(n-1,-1,-1):
    finv[i] = (finv[i+1]*(i+1))%mod
heappush(lis,q[0][1])
ans=0
for i in range(1,n):
    while lis and lis[0]<q[i][0]:
        heappop(lis)
    if len(lis)>=k-1:
        ans=(ans+f[len(lis)]*finv[k-1]*finv[len(lis)-k+1])%mod
    heappush(lis,q[i][1])
out(ans)
