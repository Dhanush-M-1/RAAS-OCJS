# -*- coding: utf-8 -*-
"""
Created on Thu Oct 17 19:18:55 2019

@author: lenovo
"""

t=int(input())
while t>0:
    t-=1
    a,b,c=input().split()
    a=int(a)
    b=int(b)
    c=int(c)
    sum=0
    r=0
    e=0
    #print(a,b,c,(c>=2 and b>=1),( b>=2 and a>=1))
    while (( b>=2 and a>=1) or (c>=2 and b>=1) ):
        e=0
        r=0
        #print("bjhf")
        if((c>=2 and b>=1)):
            c-=2
            b-=1
            e=1
            sum=sum+3
            #print(sum,b,c,e)
        elif( b>=2 and a>=1):
            b-=2
            a-=1
            r=1
            sum=sum+3
        if(e==0 and r==0):
            break
    print(sum)