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
def ans(a,b):
    #print(a,b)
    c=0
    if a*2>b:
        x=b//2
        b=b%2
        c=c+x*2+x
        a=a-x
    else:
        x=a
        a=0
        b=b-x*2
        c=c+x*2+x
    #print(a,b,c)
    return a,b,c
def ans1(a,b,c):
    an=0
    for i in range(0,b+1,2):
        an=max(an,ans(a,i)[2]+ans((b-i),c)[2])
    return an
n=int(inp())
for i in range(n):
    a,b,c=line()
    print(ans1(a,b,c))
    '''x1,y1,z1=ans(a,b)
    x2,y2,z2=ans(b,c)
    if z1>z2:
        a=x1
        b=y1
        k,l,h=ans(b,c)
        res=z1+h
    else:
        b=x2
        c=y2
        k,l,h=ans(a,b)
        res=z2+h
    print(res)'''
    
    
