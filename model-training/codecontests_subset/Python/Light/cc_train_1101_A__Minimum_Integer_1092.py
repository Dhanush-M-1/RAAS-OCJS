# -*- coding: utf-8 -*-
"""
Created on Mon Jan  7 17:15:42 2019

@author: Himanshu Gwalani
"""

for _ in range(int(input())):
    l,r,d = map(int,input().split())
    temp = l//d
    if temp>1:
        print(d)
    elif temp==1 and l>d:
        print(d)
    else:
        if d>r:
            print(d)
            continue
        temp = r//d
        
        print((temp+1)*d)