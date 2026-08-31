# -*- coding: utf-8 -*-
"""
Created on Fri Jul 17 23:25:01 2020

@author: user
"""

t=int(input())
l=[] 
x=[]
h=[]
for i in range(t):
    l.append(list(map(int,input().split())))
#print(l)

for i in range(t):
    x.append(l[i][0])
    h.append(l[i][1])  
#print(x)
#print(h)
c=0
d=x[0]
i=1
while(i<t-1):
    if(x[i]-h[i]>d):
        c+=1
        d=x[i]
    elif(x[i]+h[i]<x[i+1]):
        c+=1
        d=x[i]+h[i]
    else:
        d=x[i]
    i+=1 
if(t==1):
    print(1)
else:
    print(c+2)
        
        
        
        
        
        
        
        
        
        
        
        
        
        









