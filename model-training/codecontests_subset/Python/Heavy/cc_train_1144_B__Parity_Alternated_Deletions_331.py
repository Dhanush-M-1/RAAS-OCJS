#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Mar 31 08:16:08 2019

@author: samuel
"""

nothing=input()
r=input().split()
s=[]
for i in r:
    s.append(int(i))
even=[]
uneaven=[]
for i in s:
    if i%2==1:
        uneaven.append(i)
    else:
        even.append(i)
        
even.sort()
uneaven.sort()

if len(uneaven)==0:
    if len(even)>0:
        even.pop()
elif len(even)==0:
    if len(uneaven)>0:
        uneaven.pop()
else:
    if len(even)>len(uneaven):
        even.pop()
        while len(uneaven)>0:
            even.pop()
            uneaven.pop()
    elif len(uneaven)>len(even): 
        uneaven.pop()
        while len(even)>0:
            even.pop()
            uneaven.pop()
    else:
        while len(even)>0:
            even.pop()
            uneaven.pop() 
sum=0
for i in even:
    sum+=i
for i in uneaven:
    sum+=i
    
    
print(sum)