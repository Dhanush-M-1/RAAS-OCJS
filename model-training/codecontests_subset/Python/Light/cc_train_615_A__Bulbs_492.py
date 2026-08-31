# -*- coding: utf-8 -*-
"""
Created on Tue Nov  3 13:59:01 2020

@author: hanks
"""

n,m=[int(x) for x in input().split()]
l=[1]*m
for x in range(n):
    lx=[int(x) for x in input().split()]
    for i in range(lx[0]):l[lx[i+1]-1]=0
print(['YES','NO'][sum(l)!=0])