# -*- coding: utf-8 -*-
"""
Created on Tue Nov  3 13:57:19 2020

@author: 86133
"""

n, m = map(int, input().split())
c = 1
d = [0 for i in range(200)]
for i in range(n):
    a = [int(j) for j in input().split()]
    for j in a[1:]:
        d[j] = 1
for i in d[1:m+1]:
    if not i:
        c = 0
        print('NO')
        break
if c:
    print('YES')