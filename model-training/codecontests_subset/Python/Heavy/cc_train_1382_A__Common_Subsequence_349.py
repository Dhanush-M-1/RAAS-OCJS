# -*- coding: utf-8 -*-
"""
Created on Sun Jul 19 14:25:38 2020

@author: Mridul Garg
"""
w = int(input())
for o in range(w):
    n, m = list(map(int, input().split(" ")))
    A = list(map(int, input().split(" ")))
    B = list(map(int, input().split(" ")))
    
    dic = {}
    for i in B:
        dic[i] = 1
    
    done = False
    for i in A:
        if i in B:
            print("YES")
            print(1, i)
            done = True
            break
    if not done:
        print("NO")
        
        
    
    
        
    
    