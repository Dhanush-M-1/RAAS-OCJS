import math
q=int(input())
for _ in range(q):
    n=int(input())
    l=list(map(int,input().split()))
    s=0
    k=0
    maxx=-1
    minn=10**9+1
    for i in range(n):
        if i>0 and l[i]==-1 and l[i - 1]!=-1:
            maxx=max(maxx,l[i-1])
            minn=min(minn,l[i-1])
        if i<n - 1 and l[i] ==-1 and l[i + 1]!=-1:
            maxx=max(maxx,l[i+1])
            minn=min(minn,l[i+1])
    k=(maxx+minn)//2        
    for i in range(n):
        if l[i]==-1:
            l[i]=k 
    maxx_diff=-1
    for i in range(n-1):
        maxx_diff=max(maxx_diff,abs(l[i+1]-l[i]))
    print(maxx_diff,k)    
        