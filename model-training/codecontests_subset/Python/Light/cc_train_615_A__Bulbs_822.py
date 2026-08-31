# -*- coding: utf-8 -*-
"""
Created on Thu Nov  5 09:05:28 2020

@author: 章斯岚
"""

n,m=map(int,input().split())
a=set()
for i in range(n):
    k=input().split()
    for x in k[1::]:
        a.add(int(x))
b=set(range(1,m+1))
if a==b:
    print('YES')
else:
    print('NO')
   