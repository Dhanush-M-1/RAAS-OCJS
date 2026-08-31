# -*- coding: utf-8 -*-
"""
Created on Wed Nov  4 08:01:37 2020

@author: feibiaodi
"""

n,m=[int(x) for x in input().split()]
list1=[]
for i in range(0,n):
    t=input().split()
    for j in t[1:]:
        list1.append(j)
list2=list(set(list1))
if len(list2)!=m:
    print("NO")
else:
    print("YES")