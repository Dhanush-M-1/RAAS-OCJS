# -*- coding: utf-8 -*-
"""
Created on Wed Jan 22 19:40:08 2020

@author: DELL
"""


t=int(input())
for i in range(t):
    n=int(input())
    y=list(map(int,input().split()))
    if n==1:
        print("Yes")
    else:
        pr=1
        for i in range(n // 2):
            if y[i] < i or y[n - 1 - i] < i:
                print('No')
                pr = 0
                break
        if pr:
            if n % 2 == 0:
                if y[n // 2 - 1] == y[n // 2] and y[n // 2] == n // 2 - 1:
                    print('No')
                else:
                    print('Yes')
            else:
                if y[n // 2] >= n // 2:
                    print('Yes')
                else:
                    print('No')
            
            
