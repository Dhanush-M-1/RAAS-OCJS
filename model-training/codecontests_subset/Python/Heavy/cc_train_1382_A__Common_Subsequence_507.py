# -*- coding: utf-8 -*-
"""
Created on Tue Jul 21 20:08:52 2020

@author: rishi
"""


import math

def sumofno(n):
    summ=0
    while(n>0):
        summ+=n%10
        n//=10
    return summ

def get_key(val,lis): 
    for key, value in lis.items(): 
         if value == val : 
             return key 

try:
    t=int(input())
    ans=[]
    
    for i in range(t):
        n,m=input().split()
        n=int(n)
        m=int(m)
        a=list(map(int,input().split()))
        b=list(map(int,input().split()))
        aset=set(a)
        bset=set(b)
        if(len(aset.intersection(bset))):
            #print("hi")
            c=aset.intersection(bset)
            c=list(c)
            #print(c[0])
            ans.append("YES")
            ans.append(str(1)+" "+str(c[0]))
        else:
            ans.append("NO")
    #print(ans)     
    for an in ans:
        print(an)
except:
    pass
            
        