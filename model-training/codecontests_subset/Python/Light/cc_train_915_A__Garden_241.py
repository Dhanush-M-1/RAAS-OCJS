# -*- coding: utf-8 -*-
"""
Created on Fri Jun 28 06:57:04 2019

@author: avina
"""

n,k = map(int, input().split())
l = list(map(int, input().split()))
a = 0
for i in range(n):
    if k % l[i] == 0 and l[i] > a:
        a = l[i]
print(k//a)
        