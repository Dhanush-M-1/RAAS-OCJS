import sys, math
import io, os
#data = io.BytesIO(os.read(0,os.fstat(0).st_size)).readline
from bisect import bisect_left as bl, bisect_right as br, insort
from heapq import heapify, heappush, heappop
from collections import defaultdict as dd, deque, Counter
# from itertools import permutations,combinations
def data(): return sys.stdin.readline().strip()
def mdata(): return list(map(int, data().split()))
def outl(var): sys.stdout.write(' '.join(map(str, var)) + '\n')
def out(var): sys.stdout.write(str(var) + '\n')
from decimal import Decimal
# from fractions import Fraction
# sys.setrecursionlimit(100000)
mod = int(1e9) + 7
INF=10**9

n=int(data())
a=mdata()
if n==1:
    print(1,1)
    out(-a[0])
    print(1, 1)
    out(0)
    print(1, 1)
    out(0)
    exit()
print(1,n-1)
ans=[]
for i in range(n-1):
    ans.append((n-1)*a[i])
    a[i]+=(n-1)*a[i]
outl(ans)
print(n,n)
out(-a[-1])
print(1,n)
a[-1]=0
ans=[]
for i in range(n):
    ans.append(-a[i])
outl(ans)


