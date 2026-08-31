# -*- coding: utf-8 -*-
"""
Created on Sat Jan  4 19:20:02 2020

@author: PC
"""

def stones(A):
    
    stones = 0
    while (A[0] > 0 and A[1] > 1) or (A[2] > 1 and A[1] > 0):
        if A[2] > 1 and A[1] > 0:
            A[1] -= 1
            A[2] -= 2
            stones += 3
        elif A[0] > 0 and A[1] > 1:
            A[1] -= 2
            A[0] -= 1
            stones += 3
    return stones

t = int(input())
for i in range(t):
    arr = list(map(int, input().split()))
    print(stones(arr))
    
     