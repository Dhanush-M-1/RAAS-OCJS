# -*- coding: utf-8 -*-
"""
Created on Wed Jul 10 20:06:42 2019

@author: avina
"""

a,b = map(int, input().split())
w = a 
q = 0
while a>= b:
    w+= a//b
    q= a%b
    a = a//b + q

print(w)