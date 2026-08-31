# -*- coding: utf-8 -*-
"""
Created on Sun Feb 11 17:42:31 2018

@author: arjun
"""

f1,f2 = list(map(str,input().split()))
print(f1,f2)
n = int(input())
for _ in range(n):
    dead,replace = list(map(str,input().split()))
    if(dead==f1):
        f1 = replace
    else:
        f2 = replace
    print(f1,f2)