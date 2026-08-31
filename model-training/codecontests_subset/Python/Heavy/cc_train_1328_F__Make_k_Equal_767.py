import math as mt
import sys,string
input=sys.stdin.readline
from collections import defaultdict
L=lambda : list(map(int,input().split()))
Ls=lambda : list(input().split())
M=lambda : map(int,input().split())
I=lambda : int(input())


n,k=M()
l=L()
x=set()
for i in l:
    r=i
    while(r):
        x.add(r)
        r=r//2
        x.add(r)
ans1=10**10

for i in x:

    h=[]
    for j in range(len(l)):
        ans=0
        d=l[j]
        if(d>=i):
            while(d>i):

                d//=2
                ans+=1
        if(d==i):
            h.append(ans)

    if(len(h)>=k):
        h.sort()
        ans1=min(ans1,sum(h[:k]))
print(ans1)
    
