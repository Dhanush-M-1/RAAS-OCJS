# -*- coding: utf-8 -*-
"""
Created on Thu Jul  9 09:18:37 2020

@author: Harshal
"""



n,k=map(int,input().split());
z=[]
x=[]
y=[]

for _ in range(n):
    t,a,b=map(int,input().split())
    if a&b:
        z.append(t)
    elif a:
        x.append(t)
    elif b:
        y.append(t)
x.sort()
y.sort()
    
for i in range(min(len(x),len(y))):
    z.append(x[i]+y[i])
z.sort()

print( -1 if len(z)<k else sum(z[:k]))