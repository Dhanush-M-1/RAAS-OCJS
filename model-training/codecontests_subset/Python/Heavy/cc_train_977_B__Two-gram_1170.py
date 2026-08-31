#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Jul  4 09:41:19 2018

@author: ahmed
"""

###
import sys
data = sys.stdin.readlines()

lis = []

for line in data:
    lis.append(line)
###
def dadd(key, dic):
    """add a key and a value to a dictionary even if the key doesn't exist"""
    if key in dic:
        dic[key] += 1
        
    else:
        dic[key] = 1
_ = lis[0] #no needs for that 
word = lis[1]

counter = {}
for i in range(len(word)-2):
    gram = word[i:i+2]
    dadd(gram, counter)

counter = list(counter.items())
counter.sort(key= lambda x: x[1])
#print(counter)
print(counter[-1][0])
