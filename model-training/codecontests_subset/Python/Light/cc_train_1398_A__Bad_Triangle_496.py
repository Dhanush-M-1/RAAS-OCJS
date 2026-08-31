# -*- coding: utf-8 -*-
"""
Created on Fri Aug 14 20:10:59 2020

@author: Utkarsh
"""

n=int(input(''))
a=[]
while n>0:
    l=int(input(''))
    a=list(map(int, input().split(' ')[:l]))

    for i in range(0,l):
        if a[i]+a[i+1]<=a[l-i-1]:
            print( i+1, i+2,l-i)
            break
        else:
            print(-1)
            break
    n-=1
    