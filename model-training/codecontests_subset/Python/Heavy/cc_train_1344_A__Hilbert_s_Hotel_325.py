from collections import *
from bisect import *
from math import *
import sys
input=sys.stdin.readline
t=int(input())
while(t):
    t-=1
    n=int(input())
    a=list(map(int,input().split()))
    check=[]
    for i in range(n):
        shift=i+a[i%n]
        check.append(shift)
    new=[]
    for i in check:
        if(i%n==0):
            new.append(0)
            continue
        if(i>0):
            new.append(i%n)
            continue
        f=ceil(abs(i)/n)
        new.append((f*n)+i)
    flag=0
    new.sort()
    ref=new[0]
    for i in range(1,len(new)):
        if(new[i]-ref==1):
            ref=new[i]
            continue
        flag=1
        break
    if(flag==1):
        print("NO")
    else:
        print("YES")
