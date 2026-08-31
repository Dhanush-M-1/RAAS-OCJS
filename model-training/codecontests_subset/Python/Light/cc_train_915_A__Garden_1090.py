# -*- coding: utf-8 -*-
"""
Created on Mon Jan 15 23:09:24 2018

@author: Paras Sharma
"""
n,l=list(map(int,input().split()))
dur=list(map(int, input().split()))
dur.sort(reverse=True)
#print(dur)
for i in dur:
    if l%i==0:
        print(int(l/i))
        break