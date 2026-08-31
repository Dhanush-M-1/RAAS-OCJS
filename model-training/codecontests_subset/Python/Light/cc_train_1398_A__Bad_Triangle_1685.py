# -*- coding: utf-8 -*-
"""
t=int(input())
for _ in range(t):
    n=int(input())
    x=list(map(int,input().split()))
    k,m=map(int,input().split())
    s=input()
 
@author: krishna
"""
t=int(input())
for _ in range(t):
    n=int(input())
    x=list(map(int,input().split()))
    f=0
    l=x[-1]
    for i in range(n-1):
        #print(i)
        if x[i]+x[i+1]<=l:
            print(i+1,i+2,n)
            f=-1
            break
    if f==0:
        print(-1)
            
            
            
        
            
    

            
        