import sys, math
import io, os
#data = io.BytesIO(os.read(0,os.fstat(0).st_size)).readline
from bisect import bisect_left as bl, bisect_right as br, insort
from heapq import heapify, heappush, heappop
from collections import defaultdict as dd, deque, Counter
#from itertools import permutations,combinations
def data(): return sys.stdin.readline().strip()
def mdata(): return list(map(int, data().split()))
def outl(var) : sys.stdout.write(' '.join(map(str, var))+'\n')
def out(var) : sys.stdout.write(str(var)+'\n')
#from decimal import Decimal
#from fractions import Fraction
#sys.setrecursionlimit(100000)
INF = float('inf')
mod = int(1e9)+7

n,p,w,d=mdata()
cnt=0
if w%d==0 and p%d!=0:
    out(-1)
    exit()
while (w*cnt)%d!=p%d:
    cnt+=1
cnt1=d//math.gcd(w,d)
p-=cnt*w
if p<0:
    out(-1)
    exit()
k=(p//(cnt1*w))*cnt1
if k+cnt+(p-k*w)//d<=n:
    print(k+cnt,(p-k*w)//d,n-k-cnt-(p-k*w)//d)
else:
    out(-1)
