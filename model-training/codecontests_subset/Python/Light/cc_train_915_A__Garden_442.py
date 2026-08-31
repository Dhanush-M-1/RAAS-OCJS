# -*- coding: utf-8 -*-
"""
Created on Sat Jan 13 08:04:57 2018

@author: ENVY M6
"""

n,k= map(int,input().split())
buckets=list(map(int,input().split()))
buckets.sort()
for i in range(len(buckets)-1,-1,-1):
    if k%buckets[i]==0:
        print(int(k/buckets[i]))
        break
