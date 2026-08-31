# -*- coding: utf-8 -*-
"""
Spyder Editor

This is a temporary script file.
"""
import sys

def sol(n, k, bs):
    
    bs = sorted(bs)
    
    
    for i in range(n-1, -1, -1):
        
        if k % bs[i]  == 0:
            return k//bs[i]

[n, k] = input().strip().split()

[n, k] = [int(n), int(k)]

bs = [int(x) for x in input().strip().split()]

print(sol(n, k, bs))