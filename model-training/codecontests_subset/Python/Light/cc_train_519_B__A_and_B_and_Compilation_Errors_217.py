# -*- coding: utf-8 -*-
"""
Created on Sat Dec 23 16:04:18 2017

@author: admin
"""

input()
s = []
for i in range(3):
    error = [int(x) for x in input().split()]
    s.append(sum(error))
print(s[0]-s[1])
print(s[1]-s[2])
