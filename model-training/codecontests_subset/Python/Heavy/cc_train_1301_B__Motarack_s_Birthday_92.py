t=int(input())
for _ in range(t):
    n=int(input())
    l=list(map(int,input().split()))
    p=[]
    for i in range(1,n-1):
        if (l[i-1]==-1 or l[i+1]==-1) and l[i]!=-1:
            p.append(l[i])
    if l[1]==-1 and l[0]!=-1:
        p.append(l[0])
    if l[n-2]==-1 and l[n-1]!=-1:
        p.append(l[n-1])
    if p==[]:
        print(0,0)
    else:
        if len(p)==1:
            k=p[0]
        else:
            k=(max(p)+min(p))//2
        for i in range(n):
            if l[i]==-1:
                l[i]=k
        m=0
        for i in range(1,n):
            if abs(l[i]-l[i-1])>m:
                m=abs(l[i]-l[i-1])
        print(m,k)