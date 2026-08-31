# -*- coding: utf-8 -*-
"""
Created on Fri Oct 19 10:41:31 2018

@author: Quaint Sun
"""



a,b=map(int,input().split())

t=0
while a>0:
    a=a-1
    t=t+1
    if t%b==0:
        a=a+1

print(t)












