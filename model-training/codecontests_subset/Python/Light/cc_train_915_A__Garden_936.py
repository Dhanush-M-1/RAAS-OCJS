#!/usr/bin/python
# -*- coding: UTF-8 -*-


a=(int(n) for n in input().split(" "))
b=(int(n) for n in input().split(" "))
c=[]
for i in a:
    c.append(i)
maxx=0
#print(c[1])
for i in b:
    #print(i)
    if c[1]%i == 0 and i >maxx:
        maxx=i
ans=int(c[1]/maxx)
print(ans)