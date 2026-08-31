# -*- coding: utf-8 -*-
"""
Created on Tue Nov  3 13:20:51 2020

@author: 86183
"""

n,m=[int(x) for x in input().split()]
p=[]
for i in range(n):
    a=[str(x) for x in input().split()]
    p.extend(a[1:])
print(['NO','YES'][len(set(p))-m==0])