# -*- coding: utf-8 -*-
"""
Created on Sun Oct 18 15:21:50 2020

@author: Dark Soul
"""

t=int(input(''))

for _ in range(t):
    ans=[]
    n=int(input(''))
    
    
    for j in range(n):
        ans.append(list(input('')))
    
    
    x=ans[0][1]
    y=ans[1][0]
    z=ans[n-1][n-2]
    a=ans[n-2][n-1]
    if x==y:
        if z==x:
            if x==a:
                print(2)
                print(1,2)
                print(2,1)
            else:
                print(1)
                print(n,n-1)
        else:
            if x==a:
                print(1)
                print(n-1,n)
            else:
                print(0)
        continue
    if z==a:
        if x==y:
            if x==z:
                print(2)
                print(1,2)
                print(2,1)
            else:
                print(0)
        else:
            if x==z:
                print(1)
                print(1,2)
            else:
                print(1)
                print(2,1)
        continue
    if x==z:
        print(2)
        print(1,2)
        print(n-1,n)
    else:
        print(2)
        print(1,2)
        print(n,n-1)
            
                
                
        
            