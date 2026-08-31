# -*- coding: utf-8 -*-
"""
Created on Fri Feb 16 21:56:50 2018

@author: Rakib
"""
n = int(input())
s = input()
a = s.split()
for i in range(0,len(a)):
    a[i] = int(a[i])
max1 = 2
min2 = 999999
isThere = False
isHere = False
for i in range(n):
    if a[i] > 500000:
        isThere = True
    if a[i] <= 500000:
        isHere = True
for i in range(n):        
    if (a[i] <= 500000) & (a[i] > max1):
        max1 = a[i]
        
    if (a[i] > 500000) & (a[i] < min2):
        min2 = a[i]
        
#print(max1)
#print(min2)
if isThere & isHere:
    total = max(max1 - 1,1000000 - min2)       #print(min2)
elif isThere:
    total = 1000000 - min2
elif isHere:
    total = max1 - 1 

print(total)