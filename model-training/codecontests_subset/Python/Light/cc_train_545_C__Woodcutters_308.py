# -*- coding: utf-8 -*-
"""
Created on Wed Jun 24 08:39:22 2020

@author: Harshal
"""


n=int(input())
trees=[]
for _ in range(n):
    a,b=map(int,input().split())
    trees.append([a,b])
    
occ=trees[0][0]
ans=1
for i in range(1,n):
    cur=trees[i]
    
    if cur[0]-cur[1]>occ:
        ans+=1
        occ=cur[0]
    elif i==n-1:
        ans+=1
    elif cur[0]+cur[1]<trees[i+1][0] :
        
            ans+=1
            occ=cur[0]+cur[1]
    else:
        occ=cur[0]
print(ans)