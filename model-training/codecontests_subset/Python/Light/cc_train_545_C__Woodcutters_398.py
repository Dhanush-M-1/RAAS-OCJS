# -*- coding: utf-8 -*-
"""
Created on Thu Nov 12 18:49:44 2020

@author: Morris
"""

n=int(input())
tree=[[int(x) for x in input().split()]for i in range(n)]
m=2
for i in range(1,n-1):
    if tree[i][0]-tree[i][1]>tree[i-1][0]:
        m+=1
    elif tree[i][0]+tree[i][1]<tree[i+1][0]:
        m+=1
        tree[i][0]=tree[i][0]+tree[i][1]
if n==1:
    print(1)
else:
    print(m)