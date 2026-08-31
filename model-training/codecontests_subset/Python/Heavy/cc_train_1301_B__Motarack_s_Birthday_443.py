t=int(input())
for itr in range(t):
    n=int(input())
    li=list(map(int,input().split()))
    mx=-1000000010
    mn=1000000010
    for i in range(n):
        if(i>0 and li[i]==-1 and li[i-1]!=-1):
            mx=max(mx,li[i-1])
            mn=min(mn,li[i-1])
        if(i<n-1 and li[i]==-1 and li[i+1]!=-1):
            mx=max(mx,li[i+1])
            mn=min(mn,li[i+1])
    k=int((mx+mn)/2)
    if(mx==-1000000010):
        k=0
    m=0
    for i in range(n):
        if(li[i]==-1):
            li[i]=k
        if(i>0):
            m=max(m,abs(li[i]-li[i-1]))
    print(m, k)