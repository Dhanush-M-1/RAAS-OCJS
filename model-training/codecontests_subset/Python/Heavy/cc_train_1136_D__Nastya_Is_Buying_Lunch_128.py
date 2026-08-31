import sys
import math as mt
input=sys.stdin.buffer.readline  
t=1

#t=int(input())
for _ in range(t):
    #n=int(input())
    n,m=map(int,input().split())
    l=list(map(int,input().split()))
    d={}
    for i in range(1,n+1):
        d[i]=[]
    pos={}
    for i in range(n):
        pos[l[i]]=i
    for ____ in range(m):
        u,v=map(int,input().split())
        d[u].append(v)
    p=[]
    d1=[0]*(n+1)
    for i in range(n):
        d1[l[0]]=0
    d1[l[n-1]]=1
    pres=1
    ans=0
    for i in range(n-2,-1,-1):
        cnt=0
        for j in range(len(d[l[i]])):
            if d1[d[l[i]][j]]==1:
                cnt+=1
        if cnt==pres:
            ans+=1
        else:
            pres+=1
            d1[l[i]]=1
    print(ans)        
            
            