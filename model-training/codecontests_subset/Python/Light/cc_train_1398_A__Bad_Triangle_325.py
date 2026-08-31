# -*- coding: utf-8 -*-
"""
Created on Fri Aug 14 20:14:36 2020

@author: sachd
"""

t=int(input())
for i in range(t):
    n=int(input())
    s=input().split()
    ls=[]
    for j in range(len(s)):
        ls.append(int(s[j]))
    c=ls[n-1]
    a=ls[0]
    b=ls[1]
    if a+b>c:
        print(-1)
    else:
        print(1),
        print(2),
        print(n)
        