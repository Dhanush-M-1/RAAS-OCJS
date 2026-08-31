# -*- coding: utf-8 -*-
"""
Created on Tue Nov  3 13:22:48 2020

@author: Cui Shiao
"""

a,b=[int(x) for x in input().split()]
s=set()
for y in range(a):
    k=input().split()
    k.pop(0)
    s.update(k)
    k=[]
if len(s)==b:
    print("YES")
else:
    print("NO")