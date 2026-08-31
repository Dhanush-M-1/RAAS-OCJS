# -*- coding: utf-8 -*-
"""
Created on Fri Aug 14 20:11:56 2020

@author: The Wonder Land
"""

for _ in range(int(input())):
    n = int(input())
    val = list(map(int, input().strip().split()))
    index = [1, 2]
    sum_tri = val[0] + val[1]
    for i in range(2, len(val)):
        #print("i =", i)
        if (val[i] >= sum_tri):
            index.append(i+1)
            print(*index)
            break
        if i+1 == len(val):
            print("-1")
            break
    
    
    



"""
4 6 11 11 15 18 20
10 10 10 11
10 10 10 11
"""