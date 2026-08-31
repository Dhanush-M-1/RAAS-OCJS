# -*- coding: utf-8 -*-
"""
Created on Wed Nov  4 18:45:17 2020

@author: 86198
"""

n,m=map(int,input().split())
l=[]
for i in range(n):
    l1=[int(i)for i in input().split()]
    for i in range(1,l1[0]+1):
        l.append(l1[i])
l=list(set(l))
l2=[int(i)for i in range(1,m+1)]
print(['NO','YES'][l2==l])
        