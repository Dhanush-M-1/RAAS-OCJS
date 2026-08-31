from collections import defaultdict as dc
'''from collections import deque as dq
from bisect import bisect_left,bisect_right,insort_left'''
import sys
import math
#define of c++ as inl=input()
mod=10**9 +7
def bs(a,x):
    i=bisect_left(a,x)
    if i!=len(a):
        return i
    else:
        return len(a)
def bs(a,b):
    l=a
    r=b+1
    x=b
    ans=0
    while(l<r):
        mid=(l+r)//2
        if x|mid>ans:
            ans=x|mid
            l=mid+1
        else:
            r=mid
    return ans
def digit(n):
    a=[]
    while(n>0):
        a.append(n%10)
        n=n//10
    return a
def inp():
    p=int(input())
    return p
def line():
    p=list(map(int,input().split()))
    return p
def opt(a,m,b,q,mid):
    p=q.copy()
    arr=a.copy()
    s=0
    for i in range(len(arr)):
        arr[i]=(arr[i]+mid)%m
        if p[arr[i]]==0:
            return 0
        p[arr[i]]=p[arr[i]]-1
    return 1
def ans(a,b,p,z,m):
    pq=dc(int)
    xy=float('inf')
    for i in range(n):
        if a[i]<=z:
            x=z-a[i]
        elif a[i]>z:
            x=z+m-a[i]
        if pq[x]==0:
            pq[x]=1
            if opt(a,m,b,p,x):
                xy=min(xy,x)
    return xy
n,m=line()
a=line()
b=line()
p=dc(int)
a.sort(reverse=True)
z=max(b)
for i in b:
    p[i]+=1
if opt(a,m,b,p,0):
    print(0)
else:
    print(ans(a,b,p,z,m))