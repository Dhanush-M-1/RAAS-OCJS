t=int(input())
for _ in range(t):
    n=int(input())
    l=list(map(int,input().split()))
    sm=0
    for i in range(n-1):
        if l[i]!=(-1) and l[i+1]!=(-1):
            m=abs(l[i]-l[i+1])
            sm=max(m,sm)
    r=[]
    if l[0]==-1 and l[1]!=-1:
        r.append(l[1])
    if l[n-1]==-1 and l[n-2]!=-1:
        r.append(l[n-2])
    for i in range(1,n-1):
        if l[i]==-1:
            if l[i+1]!=-1:
                r.append(l[i+1])
            if l[i-1]!=-1:
                r.append(l[i-1])
    r.sort()
    p=len(r)
    if p>0:
        k=r[p-1]-r[0]
        k=k//2
        k=k+r[0]
        mx=max((r[p-1]-k),(k-r[0]))
    else:
        mx=sm
        k=0

    sm=max(mx,sm)
    print(sm,k)





