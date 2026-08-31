# -*- coding: utf-8 -*-
"""
Created on Mon Nov 23 21:30:12 2020

@author: 17831
"""

n = int(input())
a = [[int(x) for x in input().split()] for i in range(n)]
c = [abs(a[i][0]-a[i-1][0])for i in range(1,n)]
if n == 1:
    print(1)
else:
    s = 2
    for i in range(1,n-1):
        if a[i][1] < c[i - 1]:
            s+=1
        elif a[i][1] < c[i]:
            s+=1
            c[i]-=a[i][1]
        else:
            continue
    print(s)