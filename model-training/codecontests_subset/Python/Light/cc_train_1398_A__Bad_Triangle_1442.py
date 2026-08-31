# -*- coding: utf-8 -*-
"""
Created on Fri Aug 14 09:48:33 2020

@author: Tuong
"""

t = int(input())
for m in range(t):
    n = int(input())
    a_n = [int(i) for i in input().split()]
    if a_n[0] + a_n[1] <=  a_n[-1]:
        print(1, 2, n)
    else:
        print(-1)