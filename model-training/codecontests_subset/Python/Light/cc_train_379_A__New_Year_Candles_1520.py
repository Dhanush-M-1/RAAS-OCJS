# -*- coding: utf-8 -*-
"""
Created on Fri May 15 08:38:32 2020

@author: Harshal
"""

n,m=list(map(int,input().split()))
ans=n

while n>=m:
    ans+=n//m
    n=n//m + n%m
print(ans)

