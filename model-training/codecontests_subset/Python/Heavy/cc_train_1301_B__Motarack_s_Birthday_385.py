# -*- coding: utf-8 -*-
"""
Created on Sat Oct 24 01:28:09 2020

@author: Dark Soul
"""

for _ in range(int(input(''))):
    n=int(input(''))
    arr=list(map(int,input().split()))
    dorkar=[]
    if n==2:
        arr.sort()
        if arr[1]==-1:
            print(0,1)
            
        else:
            if arr[0]==-1:
                print(0,arr[1])
        continue
    for i in range(n):
        if arr[i]!=-1:
            if i==0:
                if arr[i+1]==-1:
                    dorkar.append(arr[i])
            elif i==(n-1):
                if arr[i-1]==-1:
                    dorkar.append(arr[i])
            else:
                if arr[i-1]==-1 or arr[i+1]==-1:
                    dorkar.append(arr[i])
    if len(dorkar)==0:
        print(0,0)
        continue
    k=(min(dorkar)+max(dorkar))//2
    for i in range(n):
        if arr[i]==-1:
            arr[i]=k
    m=0
    for i in range(n-1):
        m=max(m,abs(arr[i]-arr[i+1]))
    print(m,k)
        

                