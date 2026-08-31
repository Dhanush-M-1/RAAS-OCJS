# -*- coding: utf-8 -*-
"""
Created on Sat May 16 10:12:13 2020

@author: Harshal
"""

import collections 
n=int(input())
arr1=list(map(int,input().split()))
arr2=list(map(int,input().split()))
arr3=list(map(int,input().split()))

d1=collections.Counter(arr1)
d2=collections.Counter(arr2)
d3=collections.Counter(arr3)
ans=[]
for x,y in d1.items():
    if d2[x]<y:
        print(x)
    
for x,y in d2.items():
    if d3[x]<y:
        print(x)