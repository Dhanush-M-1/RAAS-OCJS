from collections import deque
import collections
import sys

def inp():
    return sys.stdin.readline().strip()
n,k=map(int,inp().split())
a=list(map(int,inp().split()))
d=collections.Counter(a)
b=list(d.keys())
mn=float('inf')
b.sort()
for i in range(max(b)+1):
    val=d.get(i,0)
    ans=0
    for j in b:
        if j>i:
            ct=0
            temp=j
            while temp>i:
                temp//=2
                ct+=1 
            if temp==i:
                if val<k and d[j]+val>=k:
                    req=k-val
                    val=k
                    ans+=req*ct
                    break
                else:
                    val+=d[j]
                    ans+=d[j]*ct
                
    if val>=k:
        mn=min(ans,mn)
print(mn)
                        
        
    
    