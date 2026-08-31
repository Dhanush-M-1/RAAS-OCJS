# -*- coding: utf-8 -*-
import sys
from heapq import heappush,heappop,heapify
sys.setrecursionlimit(10**9)
INF=10**18
MOD=10**9+7
input=lambda: sys.stdin.readline().rstrip()
YesNo=lambda b: bool([print('Yes')] if b else print('No'))
YESNO=lambda b: bool([print('YES')] if b else print('NO'))
int1=lambda x:int(x)-1

T=int(input())
for _ in range(T):
    N=int(input())
    ans=0
    left=[]
    right=[]
    for i in range(N):
        K,L,R=map(int,input().split())
        ans+=min(L,R)
        if L>=R:
            left.append((K,L-R))
        else:
            right.append((N-K,R-L))
    left.sort(key=lambda t:t[0])
    right.sort(key=lambda t:t[0])
    for l in [left,right]:
        h=[]
        for k,p in l:
            if len(h)<k:
                heappush(h,p)
            else:
                if h:
                    heappush(h,max(heappop(h),p))
        ans+=sum(h)
    print(ans)