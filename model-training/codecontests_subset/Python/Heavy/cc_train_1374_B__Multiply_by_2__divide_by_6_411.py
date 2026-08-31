# -*- coding: utf-8 -*-
"""
Created on Sun Jun 28 20:01:08 2020

@author: rishi
"""


t=int(input())
ans=[]
for i in range(t):
    n=int(input())
    if(n==1):
        ans.append(0)
        continue
    n1=n
    n2=n
    d2=0
    d3=0
    while(n1%2==0):
        d2+=1
        n1//=2
    while(n2%3==0):
        d3+=1
        n2//=3
    if((2**d2)*(3**d3)!=n):
        ans.append(-1)
        continue
    #print(d2)
    #print(d3)
    if(d3<d2):
        ans.append(-1)
    if(d3==d2):
        ans.append(d2)
    if(d3>d2):
        te=d3-d2
        ans.append(d3+te)
    
for an in ans:
    print(an)
    