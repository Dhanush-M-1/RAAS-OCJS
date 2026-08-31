import sys
import math
import random
import heapq
from collections import deque
input=sys.stdin.readline
def pow(a,n,m):
    if n==0:
        return 1 
    x=pow(a,n//2,m)
    if n%2==0 :
        return (x*x)%m 
    else:
        return (x*x*a)%m
 
def gcd(a,b):
    while b!=0:
        a,b=b,a%b
    return a 
    
def bs(arr,le,ri):
    l=0
    arr.sort()
    r=len(arr)-1
    ans=10000000
    while l<=r:
        m=(l+r)//2
        if arr[m]>=le and arr[m]<=ri:
            ans=arr[m]
            r=m-1
        elif arr[m]<le:
            l=m+1 
        else:
            r=m-1
    return ans
    
t=1
while t>0:
    n=int(input())
    a=list(map(int,input().split()))
    m=max(a)
    for i in range(n):
        a[i]=m-a[i]
    g=0 
    for i in a:
        g=gcd(g,i)
    print(sum(a)//g,g)
    t-=1