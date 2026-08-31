# -*- coding: utf-8 -*-
"""
Created on Tue Nov  5 17:06:58 2019

@author: LV
"""

a, b = map(int, input().split())
t = ash = 0
while a > 0:
    t += a
    ash = ash + a
    a, ash = ash // b, ash % b
print(t + a)