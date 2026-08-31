# -*- coding: utf-8 -*-
"""
Created on Tue Nov 27 15:42:57 2018

@author: Quaint Sun
"""


n=int(input())
xh=[]
t=0
while t<n:
    A=list(map(int,input().split()))
    xh.append(A)
    t=t+1
space=[(xh[i][0]-xh[i-1][0]) for i in range(1,n)]+[10000000000]
a=1
i=1
while i<n:
    if xh[i][1]<space[i-1]:
        a+=1
    elif xh[i][1]<space[i]:
        a=a+1
        space[i]-=xh[i][1]
    i=i+1
print(a)       
            







