import os, sys, bisect, copy
from collections import defaultdict, Counter, deque
from functools import lru_cache   #use @lru_cache(None)
if os.path.exists('in.txt'): sys.stdin=open('in.txt','r')
if os.path.exists('out.txt'): sys.stdout=open('out.txt', 'w')
#
def input(): return sys.stdin.readline()
def mapi(arg=0): return map(int if arg==0 else str,input().split())
#------------------------------------------------------------------



for _ in range(int(input())):
    n = int(input())
    a = list(mapi())
    if n<=2:
        if max(a)>=0:
            print(0,max(a))
        else:
            print(0,42)
        continue
    mx = max(a)
    if mx ==-1:
        mx = 0
    for i in range(n):
        if a[i]!=-1:
            mx = min(mx,a[i])

    l = 0
    r = int(1e9)
    def check(mid):
        mn = int(1e9)
        mx = 0
        for i in range(n-1):
            if a[i]==-1 and a[i+1]==-1:
                continue
            if a[i]==-1 or a[i+1]==-1:
                mn = min(mn,max(a[i],a[i+1])+mid)
                mx = max(mx,max(a[i],a[i+1])-mid)
        return (mn>=mx,mx)
    l = 0
    for i in range(n-1):
        if a[i]!=-1 and a[i+1]!=-1:
            l = max(l,abs(a[i]-a[i+1]))
    ans = float("inf")
    while r-l>0:
        mid = (l+r)>>1
        x,tmp = check(mid)
        if x:
            ans = tmp
            r = mid
        else:
            l = mid+1
    print(r,ans)