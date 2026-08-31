# -*- coding: utf-8 -*-
"""
Created on Thu Jun  6 13:27:02 2019

@author: avina
"""

n,m = map(int, input().split())
l = [False]*m
for i in range(n):
    g = list(map(int, input().split()))
    for i in g[1:]:
        l[i-1] = True
if sum(l) == m:
    print('YES')
else:
    print('NO')