# -*- coding: utf-8 -*-
"""
Created on Wed Jan  8 21:11:41 2020

@author: maril
"""

t=int(input(''))
L=[]

for i in range(t):
    values=input('')
    L.append(values)
    
def stones(stone):
    stone=stone.split()
    abc=[]
    for i in stone:
        abc.append(int(i))
    max=0
    while abc[1]>=1 and abc[2]>=2:
        max=max+3
        abc[1]-=1
        abc[2]-=2
    while abc[0]>=1 and abc[1]>=2:
        max=max+3 
        abc[0]-=1
        abc[1]-=2
    return max

for i in range(t): 
    print(stones(L[i]))  