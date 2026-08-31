# -*- coding: utf-8 -*-
"""
Created on Fri May 10 01:15:42 2019

@author: avina
"""

n = int(input())

s= input().strip()
l  = []
for i in range(n-1):
    if s[i] > s[i+1]:
        l.append((i, i+1,s[i:i+2]))
if len(l) == 0:
    print('NO')
else:
    l1 = l[0][0];r = l[0][1];st = l[0][2]
    for i in range(1,len(l)):
        if l[i][0] - r <= 1 and st[1] > l[i][2][1]:
            r = l[i][1]
            st = l[i][2]
        else:
            l1 = l[i][0]
            r = l[i][1]
            st = l[i][2]
    print('YES')
    print(l1 + 1, r+1)