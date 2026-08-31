# -*- coding: utf-8 -*-
"""
#k,m=map(int,input().split())
t=int(input())
for _ in range(t):
    n=int(input())
    x=list(map(int,input().split()))
    
"""
import math
t = int(input())
for _ in range(t):
    n=int(input())
    x=list(map(int,input().split()))
    q1=[0]*n
 #   q2=[1]*n
  #  q3=[1]*n
    for i in range(n):
       # print(i)
      #  q1[i]=q1[i]-1
        q1[(i+x[i%n])%n]+=1
    f=0
    for i in range(n):
        if q1[i]!=1:
            f=1
            break;
    if f==0:
        print('YES')
    else:
        print('NO')
        
    
    
    

