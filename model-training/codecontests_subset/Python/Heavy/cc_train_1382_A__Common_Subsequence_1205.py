# -*- coding: utf-8 -*-
"""
Created on Tue Jul 21 20:06:44 2020

@author: Paras
"""

test = int(input())
while test>0:
    n,m = map(int, input().split())
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))
    l = n if n<m else m
    flag=False
    if l==n:
        for i in range(n):
            if a[i] in b:
                flag=True
                print("YES")
                print("1",a[i])
                break
        if flag==False:
            print("NO")
    else:
        for i in range(m):
            if b[i] in a:
                flag=True
                print("YES")
                print("1",b[i])
                break
        if flag==False:
            print("NO")
        
    test-=1
