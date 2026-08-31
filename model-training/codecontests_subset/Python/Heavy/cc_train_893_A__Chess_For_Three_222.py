#!/usr/bin/python
# -*- coding: UTF-8 -*-


aa=int(input())
a=[]
step=aa
a.append(1)
a.append(2)
ans=0
while aa>0:
    aa-=1
    x=int(input())
    if 1 not in a and x in a:
        ans+=1
        a.clear()
        a.append(1)
        a.append(x)
    elif 2 not in a and x in a:
        ans+=1
        a.clear()
        a.append(2)
        a.append(x)
    elif 3 not in a and x in a:
        ans+=1
        a.clear()
        a.append(3)
        a.append(x)
    else:
        print("NO")
        break
if ans == step:
    print("YES")