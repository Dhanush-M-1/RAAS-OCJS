# -*- coding: utf-8 -*-
"""
Created on Sun Nov 22 01:47:53 2020

@author: pinky
"""

n=int(input())
if n==1:
    print(1)
else:
    ans=2
    a=[[int(x) for x in (input().split())] for i in range (n)]
    for i in range (1,n-1):
        if a[i][0]-a[i-1][0]>a[i][1]:
            ans+=1
        elif a[i+1][0]-a[i][0]>a[i][1]:
            ans+=1
            a[i][0]+=a[i][1]
    print(ans)


    
    