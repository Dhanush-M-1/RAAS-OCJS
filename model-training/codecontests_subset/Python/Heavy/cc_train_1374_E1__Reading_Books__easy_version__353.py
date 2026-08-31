#!/usr/bin/env python3

import sys
import heapq
input=sys.stdin.readline

n,k=map(int,input().split())
arr=[list(map(int,input().split())) for _ in range(n)]
cnt1=0
cnt2=0
for t,a,b in arr:
    if a==1:
        cnt1+=1
    if b==1:
        cnt2+=1
if cnt1<k or cnt2<k:
    print(-1)
    exit()
arr=sorted(arr,key=lambda x:x[0])
arr=sorted(arr,reverse=True,key=lambda x:x[1])
ans=0
cnt=0
for i in range(k):
    ans+=arr[i][0]
    if arr[i][2]==1:
        cnt+=1
if cnt==k:
    print(ans)
    exit()
q1=[]
q2=[]
q3=[]
for t,a,b in arr[:k]:
    if a==1 and b==0:
        heapq.heappush(q1,-t)
for t,a,b in arr[k:]:
    if a==1 and b==1:
        heapq.heappush(q2,t)
    if a==0 and b==1:
        heapq.heappush(q3,t)
INF=10**18
while cnt<k:
    if len(q1)!=0:
        diff1=INF
        if len(q2)!=0:
            cost1=heapq.heappop(q1)
            heapq.heappush(q1,cost1)
            cost2=heapq.heappop(q2)
            heapq.heappush(q2,cost2)
            diff1=cost1+cost2
        diff2=INF
        if len(q3)!=0:
            cost3=heapq.heappop(q3)
            heapq.heappush(q3,cost3)
            diff2=cost3
        if diff1!=INF and diff2==INF:
            ans+=diff1
            heapq.heappop(q1)
            heapq.heappop(q2)
        elif diff1==INF and diff2!=INF:
            ans+=diff2
            heapq.heappop(q3)
        else:
            if diff1<=diff2:
                ans+=diff1
                heapq.heappop(q1)
                heapq.heappop(q2)
            else:
                ans+=diff2
                heapq.heappop(q3)
    else:
        diff1=INF
        if len(q2)!=0:
            cost2=heapq.heappop(q2)
            heapq.heappush(q2,cost2)
            diff1=cost2
        diff2=INF
        if len(q3)!=0:
            cost3=heapq.heappop(q3)
            heapq.heappush(q3,cost3)
            diff2=cost3
        if diff1!=INF and diff2==INF:
            ans+=diff1
            heapq.heappop(q2)
        elif diff1==INF and diff2!=INF:
            ans+=diff2
            heapq.heappop(q3)
        else:
            if diff1<=diff2:
                ans+=diff1
                heapq.heappop(q2)
            else:
                ans+=diff2
                heapq.heappop(q3)
    cnt+=1
print(ans)