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
y=defaultdict(list)
ans1=10**10

for j in range(len(l)):
    ans=0
    d=l[j]
    while(d):
        y[d].append(ans)
        d//=2
        ans+=1
    if(d==0):
        y[d].append(ans)
w=list(y.keys())

ans=10**10
for i in range(len(w)):
    if(len(y[w[i]])>=k):
        ans=min(ans,sum(sorted(y[w[i]])[:k]))
print(ans)
    
    
