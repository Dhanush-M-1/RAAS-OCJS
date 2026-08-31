# -*- coding: utf-8 -*-
"""
Created on Sun Jul 14 11:56:43 2019

@author: avina
"""

n = int(input())
a = list(map(int, input().split()))
s = sum(a)
a1 = list(map(int, input().split()))
s1 = sum(a1)
print(s - s1)
a2 = list(map(int, input().split()))
print(s1 - sum(a2))