from collections import defaultdict as dc
from heapq import *
import math
from bisect import bisect_left,bisect
#bisect gives x and p[x] is element greater than it and out of bound for last one 
#p[x-1] gives equal or smaller and no error for any element.
import sys
from collections import deque as dq
from heapq import heapify,heappush,heappop
mod=10**9 +7
def inp(): 
    p=int(input())
    return p
def line():
    p=list(map(int,input().split()))
    return p
def read_mat():
    n=inp()
    a=[]
    for i in range(n):
        a.append(line())
    return a
def digit(n):
    s=str(n)
    p=0
    for i in s:
        p+=(int(i))**2
    return p
ans=0
def solve(a,n):
    p=dc(int)
    if n==1:
        return "YES"
    q=0
    for i in range(n):
        z=(i+a[i])%n
        #print(z)
        p[z]+=1
        if p[z]>1:
            return "NO"
    return "YES"
        
    
for test in range(inp()):
    n=inp()
    a=line()
    l=solve(a,n)
    print(l)