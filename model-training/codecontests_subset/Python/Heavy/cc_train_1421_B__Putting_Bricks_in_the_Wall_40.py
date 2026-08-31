import sys
input=sys.stdin.readline
from collections import defaultdict as dc
from bisect import bisect_right
import math
for _ in range(int(input())):
    n=int(input())
    l=[]
    for i in range(n):
        l.append(list(input()))
    a,b,x,y=l[0][1],l[1][0],l[n-1][n-2],l[n-2][n-1]
    if a=='1' and b=='1':
        if x=='0' and y=='0':
            print(0)
        else:
            p=[]
            c=0
            if x=='1':
                c+=1
                p.append([n,n-1])
            if y=='1':
                c+=1
                p.append([n-1,n])
            print(c)
            for t in p:
                print(*t)
    elif a=='0' and b=='0':
        if x=='1' and y=='1':
            print(0)
        else:
            p=[]
            c=0
            if x=='0':
                c+=1
                p.append([n,n-1])
            if y=='0':
                c+=1
                p.append([n-1,n])
            print(c)
            for t in p:
                print(*t)
    else:
        if x==y:
            p=[]
            if a==x:
                p=[1,2]
            else:
                p=[2,1]
            print(1)
            print(*p)
        else:
            print(2)
            if a=='1':
                print(1,2)
            elif b=='1':
                print(2,1)
            if x=='0':
                print(n,n-1)
            elif y=='0':
                print(n-1,n)
                
                
                    
                    