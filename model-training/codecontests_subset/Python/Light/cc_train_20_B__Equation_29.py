#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sat Jun 16 03:38:40 2018

@author: anshul
"""
from math import sqrt

a,b,c=list(map(int,input().split()))
if a==0 and b==0 and c==0:
    print(-1)
elif a==0 and b==0:
    print(0)
elif a==0:
    print(1)
    ans=(-1*c)/b
    print(ans)
else:
    d = b*b - 4*a*c
    if d<0:
        print(0)
    elif d>0:
        print(2)
        d=sqrt(d)
        ans1=(-b-d)/(2*a)
        ans2=(-b+d)/(2*a)
        if ans1<ans2:
            ans1,ans2=ans2,ans1
        print(ans2)
        print(ans1)
    else:
        print(1)
        ans=(-b)/(2*a)
        print(ans)