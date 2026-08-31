# -*- coding: utf-8 -*-
"""
Created on Tue Jun  2 17:41:55 2020

@author: Administrator
"""

n = int(input())
l1 = list(map(int, input().split()))
l2 = list(map(int, input().split()))
l3 = list(map(int, input().split()))

print(sum(l1)-sum(l2))
print(sum(l2)-sum(l3))