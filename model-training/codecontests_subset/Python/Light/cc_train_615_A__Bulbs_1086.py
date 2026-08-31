# -*- coding: utf-8 -*-
"""
Created on Tue Nov  3 21:38:06 2020

@author: jion
"""

n,m = map(int,input().split())
L = []
no = True
for i in range(n):
    L += (input().split())[1:]
    if len(set(L)) == m:
        no = False
        break
print(['YES','NO'][no])