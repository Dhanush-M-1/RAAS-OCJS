# -*- coding: utf-8 -*-
"""
Created on Thu Jan 18 22:25:04 2018

@author: User
"""

a,b=map(int,input().split())
arr=list(map(int,input().split()))
arr.sort()
for i in range(a-1,-1,-1):
    if b%arr[i]==0:
        print(b//arr[i])
        break


