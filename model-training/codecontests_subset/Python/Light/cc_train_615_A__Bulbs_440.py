# -*- coding: utf-8 -*-
"""
Created on Thu Nov  5 08:30:46 2020

@author: Lenovo
"""

m,n=map(int,input().split())
x=0
l=[]
while m:
    m-=1
    l1=input().split()
    l1.remove(l1[0])
    l+=l1
for i in range(1,n+1):
    if str(i) not in l:
        x+=1
if x==0:
    print('YES')
else:
    print('NO')