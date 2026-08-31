for _ in range(int(input())):
    n=int(input())
    l=list(map(int,input().split()))
    k=0;m=-1;p=10**9+7
    for i in range(n):
        if l[i]==-1:
            t=str(int(l[max(0,i-1)]!=-1))+str(int(l[min(i+1,n-1)]!=-1))
            if t=='11':
                m=max([m,l[i-1],l[i+1]])
                p=min([p,l[i-1],l[i+1]])
            elif t=="01":
                m=max(m,l[i+1])
                p=min(p,l[i+1])
            elif t=="10":
                m=max(m,l[i-1])
                p=min(p,l[i-1])
    k=(m+p)//2;m=0
    for i in range(n-1):
        if l[i]==-1:
            l[i]=k
        if l[i+1]==-1:
            l[i+1]=k
        if abs(l[i+1]-l[i])>m:
            m=abs(l[i+1]-l[i])
    print(m,k)