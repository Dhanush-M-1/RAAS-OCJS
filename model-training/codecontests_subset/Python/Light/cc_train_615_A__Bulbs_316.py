#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu Nov  5 09:28:46 2020

@author: adam_lyy
"""

n,m=map(int,input().split())
a=[list(map(int,input().split()))[1:] for i in range(n)]
s=set()
for x in a:
    for y in x:
        s.add(y)
print(["NO","YES"][len(s)==m])