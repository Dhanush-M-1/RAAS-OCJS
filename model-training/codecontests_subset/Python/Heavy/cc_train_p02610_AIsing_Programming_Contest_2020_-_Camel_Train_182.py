#!/usr/bin/env python3

import heapq
import sys
input=sys.stdin.readline

t=int(input())
for _ in range(t):
    n=int(input())
    arr=[list(map(int,input().split())) for _ in range(n)]
    q=[]
    ans=0
    camels1=[[] for _ in range(n+1)]
    camels2=[[] for _ in range(n+1)]
    for k,l,r in arr:
        ans+=min(l,r)
        if l>=r:
            camels1[k].append((l,r))
        else:
            camels2[k].append((l,r))
    for i in range(1,n+1):
        for l,r in camels1[i]:
            heapq.heappush(q,l-r)
        while len(q)>i:
            heapq.heappop(q)
    while len(q)!=0:
        ans+=heapq.heappop(q)
    for i in range(n,0,-1):
        for l,r in camels2[i]:
            heapq.heappush(q,r-l)
        while len(q)>(n-i):
            heapq.heappop(q)
    while len(q)!=0:
        ans+=heapq.heappop(q)
    print(ans)