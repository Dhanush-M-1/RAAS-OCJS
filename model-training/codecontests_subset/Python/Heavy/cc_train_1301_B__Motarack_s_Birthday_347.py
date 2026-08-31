import sys
import copy
from math import *
input=sys.stdin.readline

def bo(i):
    return ord(i)-ord('a')
t=int(input())
while t>0:
    t-=1
    #c=copy.deepcopy(a)
    n=int(input())
    a=[int(x) for x in input().split()]
    if a.count(-1)==n:
        print(0,5)
        continue
    s=[]
    for i in range(n):
        if a[i]!=-1:
            if i!=0:
                if a[i-1]==-1:
                    s.append(a[i])
            if i!=n-1:
                if a[i+1]==-1:
                    s.append(a[i])
    
    #print(s)
    k=2
    #print(s)
    ss=max(s)+min(s)
    s=ss
    #print(s)
    if k>0:                
        g=s//k   
    b=copy.deepcopy(a)    
    for i in range(n):
        if a[i]==-1:
            a[i]=g
    maxi=-10**18
    for i in range(1,n):
        maxi=max(maxi,abs(a[i]-a[i-1]))
    m1=maxi   
    if s%k==0:
        print(maxi,g) 
        continue
    g2=s//k+1
    for i in range(n):
        if b[i]==-1:
            b[i]=g2
    maxi=-10**18
    for i in range(1,n):
        maxi=max(maxi,abs(b[i]-b[i-1]))
    m2=maxi
    #print(a,b,g,g2,m1,m2)
    if m1<m2:
        print(m1,g)
    else:
        print(m2,g2)
  