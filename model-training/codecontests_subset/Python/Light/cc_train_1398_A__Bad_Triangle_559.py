# -*- coding: utf-8 -*-
"""
Created on Sat Aug 15 22:54:54 2020

@author: user
"""
t=int(input())
for i in range(t):
    n=int(input())
    arr=list(map(int,input().split()))
    if(arr[0]+arr[1]<=arr[-1]):
        print("1 2 "+str(n))
    else:
        print(-1)