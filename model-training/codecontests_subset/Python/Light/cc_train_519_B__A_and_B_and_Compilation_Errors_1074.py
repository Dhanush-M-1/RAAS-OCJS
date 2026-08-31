# -*- coding: utf-8 -*-
"""
Created on Sat May 16 10:12:13 2020

@author: Harshal
"""

n=input()

arr1=list(map(int,input().split()))
arr2=list(map(int,input().split()))
arr3=list(map(int,input().split()))

print(sum(arr1)-sum(arr2))
print(sum(arr2)-sum(arr3))