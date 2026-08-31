#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Mon Dec 31 16:19:54 2018

@author: qw_nn29
"""

n=int(input())
tree=[]
for i in range(n):
    tree.append(list(map(int,input().split())))

if n<=2:
    t=n
else:
    t=2
    for i in range(1,n-1):
        if tree[i][0]-tree[i-1][0]>tree[i][1]:
            t+=1
        elif tree[i+1][0]-tree[i][0]>tree[i][1]:
            t+=1
            tree[i][0]+=tree[i][1]

print(t)
    