from collections import defaultdict as dc
from collections import deque as dq
from bisect import bisect_left,bisect_right,insort_left
import sys
import math
#define of c++ as inl=input()
mod=10**9 +7
def bs(a,x):
    i=bisect_left(a,x)
    if i!=len(a) and a[i]==x:
        return i
    else:
        return -1
def inp():
    p=sys.stdin.readline()
    return p
def line():
    p=list(map(int,inp().split()))
    return p
n,p,w,d=line()
k=0
for y in range(w+1):
    l=p%w - ((y%w)*(d%w))%w
    if l%w==0:
        k=1
        x=(p-y*d)//w
        break
if k==1 and x+y<=n and x>=0 and y>=0:
    print(x,y,n-(x+y))
else:
    print(-1)
