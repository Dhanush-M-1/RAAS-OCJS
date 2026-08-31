# -*- coding: utf-8 -*-
"""
Created on Tue Jul 21 20:18:04 2020

@author: Arzoo
"""


t=int(input())
for i in range(t):
    mn=input()
    mn=mn.split(" ")
    m=int(mn[0])
    n=int(mn[1])
    a=input()
    a=a.split(" ")
    b=input()
    b=b.split(" ")
    if(a==b):
        print("YES")
        print(1,min(a))
    elif(len(a)==1 and len(b)==1 and a!=b):
        print("NO")
    elif(len(a)<len(b)):
        ans=[]
        for j in a:
            if(j in b):
                ans.append(j)
        #print(ans)
        if(len(ans)!=0):
            print("YES")
            print(1,min((ans)))
        else:
            print("NO")
    else:
        ans=[]
        for j in b:
            if(j in a):
                ans.append(j)
        if(len(ans)!=0):
            print("YES")
            print(1,min((ans)))
        else:
            print("NO")