# -*- coding: utf-8 -*-
"""
Created on Tue Nov 27 15:57:28 2018

@author: pc
"""
n=int(input())
x=[[0,0] for i in range(n)]
for i in range(n):
    x[i]=list(map(int,input().split()))
ans=0
for i in range(1,n-1):
    if x[i][0]-x[i][1]>x[i-1][0]:
        ans+=1
    elif x[i][0]+x[i][1]<x[i+1][0]:
        ans+=1
        x[i][0]=x[i][0]+x[i][1]
if n==1:
    print(1)
else:
    print(ans+2)
    
    