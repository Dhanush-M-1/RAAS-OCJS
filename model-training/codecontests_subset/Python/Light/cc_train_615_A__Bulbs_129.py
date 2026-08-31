#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Nov  3 13:53:32 2020

@author: apple
"""

n,m=map(int,input().split(' '))
a=set()
for i in range(n):
    b=list(map(int,input().split(' ')))
    for k in range(1,len(b)):
        a.add(b[k])
for j in range(1,m+1):
    if j not in a:
        print('NO')
        break
else:
    print('YES')