# -*- coding: utf-8 -*-
"""
#k,m=map(int,input().split())
t=int(input())
for _ in range(t):
    n=int(input())
    x=list(map(int,input().split()))
    
"""
from math import *
t=int(input())
for _ in range(t):
    n=int(input())
    x=list(map(int,input().split()))
    if n==2:
        if x[0]==-1 and x[-1]==-1:
            print(0,0)
        else:
            print(0,max(x))
        
    else:
        f=0
        mn=1e10
        mx=0
        for i in range(n):
            if x[i]!=-1:
                f=1
                if i==0:
                    if x[i+1]==-1:
                        mn=min(mn,x[i])
                        mx=max(mx,x[i])
                elif i==n-1:
                    if x[i-1]==-1:
                        mn=min(mn,x[i])
                        mx=max(mx,x[i]) 
                else:
                    if x[i+1]==-1 or x[i-1]==-1:
                        mn=min(mn,x[i])
                        mx=max(mx,x[i])   
        if f==0:
            print(0,0)
        else:
            k=(mn+mx)//2
            for i in range(n):
                if x[i]==-1:
                    x[i]=k
            m=0
            for i in range(0,n-1):
                m=max(m,abs(x[i]-x[i+1]))
            print(m,k)
            
                
                
                
                
        
            

                
            
        
        

        
    
    
    

