# -*- coding: utf-8 -*-
"""
Created on Sun Jun 28 20:53:38 2020

@author: Dark Soul
"""


t=int(input(''))
strr=[]
for i in range(t):
    inp=int(input(''))
    strr.append(inp)
for i in range(t):
    n=strr[i]
    if n==1:
        print(0)
        continue
    if n==3:
        print(2)
        continue
    cnt2=0
    cnt3=0
    flag=1
    while(flag==1 and n!=1):
        if n%2==0:
            cnt2=cnt2+1
            n=n/2
        if n%3==0:
            cnt3=cnt3+1
            n=n/3
        else:
            flag=0
    if flag==0:
        print(-1)
        continue
    if cnt3==0:
        print(-1)
    else:
        if cnt3<cnt2:
            print(-1)
        else:
            print(cnt3+(cnt3-cnt2))
    
