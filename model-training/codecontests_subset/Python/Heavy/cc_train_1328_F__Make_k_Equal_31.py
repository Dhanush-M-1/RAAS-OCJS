# -*- coding: utf-8 -*-
"""
Created on Mon Jul 27 05:12:54 2020

@author: Dark Soul
"""

MAX=int(2*1e5)+1
arr=[0]*MAX
cnt=[0]*MAX
INF=int(1e8)
[n,k]=list(map(int, input().split()))
x=list(map(int, input().split()))
x.append(0)
x.sort()
flag=0
for i in range(1,n+1):
    arr[x[i]]+=1
    if arr[x[i]]>=k:
        flag=1
if flag:
    print(0)
else:
    sol=INF
    for i in range(1,n+1):
        totop=0
        while x[i]:
            totop+=1
            x[i]=x[i]//2
            cnt[x[i]]+=totop
            arr[x[i]]+=1
            if arr[x[i]]>=k:
                sol=min(sol,cnt[x[i]])
    print(sol)