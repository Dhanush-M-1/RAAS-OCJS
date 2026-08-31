for t in range(int(input())):
    n=int(input())
    a=list(map(int,input().split()))
    if a.count(-1)==n:
        print(0,0)
    else:
        b=[]
        if (a[0]==-1 and a[1]!=-1) or (a[0]!=-1 and a[1]==-1):
            b.append((a[1] if a[1]!=-1 else a[0]))
        if (a[-1]==-1 and a[-2]!=-1) or (a[-2]==-1 and a[-1]!=-1):
            b.append((a[-2] if a[-2]!=-1 else a[-1]))
        for i in range(1,n-1):
            if a[i]!=-1:
                if a[i+1]==-1 or a[i-1]==-1:
                    b.append(a[i])
        k=(max(b)+min(b))//2
        m=abs(k-max(b,key=lambda x:abs(x-k)))
        for i in range(n-1):
            if a[i]!=-1 and a[i+1]!=-1:
                m=max(m,abs(a[i]-a[i+1]))
        print(m,k)