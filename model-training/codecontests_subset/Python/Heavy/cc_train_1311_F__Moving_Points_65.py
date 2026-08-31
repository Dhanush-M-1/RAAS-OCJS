import sys, math
import io, os
#data = io.BytesIO(os.read(0,os.fstat(0).st_size)).readline
#from bisect import bisect_left as bl, bisect_right as br, insort
#from heapq import heapify, heappush, heappop
from collections import defaultdict as dd, deque, Counter
#from itertools import permutations,combinations
def data(): return sys.stdin.readline().strip()
def mdata(): return list(map(int, data().split()))
def outl(var) : sys.stdout.write(' '.join(map(str, var))+'\n')
def out(var) : sys.stdout.write(str(var)+'\n')
#from decimal import Decimal
#from fractions import Fraction
#sys.setrecursionlimit(100000)
#INF = float('inf')
mod = int(1e9)+7

def update(BIT,v, w):
    while v <= n:
        BIT[v] += w
        v += (v & (-v))


def getvalue(BIT,v):
    ANS = 0
    while v != 0:
        ANS += BIT[v]
        v -= (v & (-v))
    return ANS


def bisect_on_BIT(BIT,x):
    if x <= 0:
        return 0

    ANS = 0
    h = 1 << (n - 1)
    while h > 0:
        if ANS + h <= n and BIT[ANS + h] < x:
            x -= BIT[ANS + h]
            ANS += h
        h //= 2

    return ANS + 1

n=int(data())
x=mdata()
v=mdata()
a=[[v[i],x[i]] for i in range(n)]
a.sort()
s=[0]*(n+1)
cnt=[0]*(n+1)
pos=dd(int)
for i in range(n):
    pos[a[i][1]]=i+1
for i in range(n):
    update(s,i+1,a[i][1])
    update(cnt,i+1,1)
ans=0
x.sort()
for i in range(n):
    ind=pos[x[i]]
    ans+=getvalue(s,n)-getvalue(s,ind)-(getvalue(cnt,n)-getvalue(cnt,ind))*x[i]
    update(s,ind,-x[i])
    update(cnt,ind,-1)
out(ans)