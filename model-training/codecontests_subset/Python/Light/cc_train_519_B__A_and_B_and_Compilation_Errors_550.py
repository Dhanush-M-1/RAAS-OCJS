# -*- coding: utf-8 -*-
"""
Created on Sun Nov 17 11:50:35 2019

@author: LV
"""

input()
s1 = sorted([int(x) for x in input().split()])
s2 = sorted([int(x) for x in input().split()] + [1000000001])
s3 = sorted([int(x) for x in input().split()] + [1000000001, 1000000001])
for i in range(len(s1)):
    if(s1[i] != s2[i]):
        print(s1[i])
        break
for i in range(len(s2)):
    if(s2[i] != s3[i]):
        print(s2[i])
        break