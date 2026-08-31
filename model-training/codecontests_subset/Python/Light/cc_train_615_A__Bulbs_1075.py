# -*- coding: utf-8 -*-
"""
Created on Thu Nov  5 07:54:29 2020

@author: 17831
"""

n,m = [int(x) for x in input().split()]
set1 = set()

for i in range(n):
    a = [int(x) for x in input().split()]
    for j in range(1,len(a)):
        set1.add(a[j])

b = (m*(1+m))/2
if b == sum(set1):
    print('YES')
else:
    print('NO')