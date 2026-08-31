import sys
for _ in range(int(input())):
    n=int(input())
    l=list(map(int,input().split()))
    minn=10**9
    maxx=-10**9
    for i in range(n):
        if i>0 and l[i]==-1 and l[i-1]!=-1:
            minn=min(minn,l[i-1])
            maxx=max(maxx,l[i-1])
            
        if i<n-1 and l[i]==-1 and l[i+1]!=-1:
            minn=min(minn,l[i+1])
            maxx=max(maxx,l[i+1])
            
            

    k=(minn+maxx)//2
    ans=0
    for i in range(n):
        if l[i]==-1:
            l[i]=k
        if i:
            ans=max(ans,abs(l[i]-l[i-1]))

    print(ans,k)
