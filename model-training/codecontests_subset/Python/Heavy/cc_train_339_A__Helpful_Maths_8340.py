# -*- coding: utf-8 -*-
"""
Created on Tue Oct 20 16:48:54 2020

@author: Cui Shiao
"""

p=input().split("+")
a=p.count("1")
b=p.count("2")
c=p.count("3")
if c!=0:
    for x in range(a):
        print("1+",end="")
    for x in range(b):
        print("2+",end="")
    for x in range(c-1):
        print("3+",end="")
    print("3")
elif b!=0:
    for x in range(a):
        print("1+",end="")
    for x in range(b-1):
        print("2+",end="")
    print("2")
else:
    for x in range(a-1):
        print("1+",end="") 
    print("1")