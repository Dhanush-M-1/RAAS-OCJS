# -*- coding: utf-8 -*-
"""
Created on Mon Dec 23 18:19:49 2019

@author: Tuan
"""

a=int(input())
b=[int(a) for a in input().split()]
c=[int(a) for a in input().split()]
d=[int(a) for a in input().split()]
print(sum(b)-sum(c))
print(sum(c)-sum(d))



