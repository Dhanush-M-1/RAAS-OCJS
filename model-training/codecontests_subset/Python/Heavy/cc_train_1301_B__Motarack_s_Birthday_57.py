for i in range(int(input())):
    n=int(input())
    a=list(map(int,input().split()))
    p=10**10
    o=-2
    for i in range(n):
        if a[i]!=-1:
            if i==0 and a[i+1]==-1:
                o=max(a[i],o)
                p=min(a[i],p)
            elif i==n-1 and a[i-1]==-1:
                o=max(a[i],o)
                p=min(a[i],p)
            elif i!=0 and i!=n-1:
                if a[i-1]==-1 or a[i+1]==-1:
                    o=max(a[i],o)
                    p=min(a[i],p)
    if o==-2 and a[0]==-1:
        print(0,0)
    else:
        m=0
        for i in range(1,n):
            if a[i]!=-1 and a[i-1]!=-1:
                m=max(m,abs(a[i]-a[i-1]))
        t=(p+o)//2
        print(max(m,abs(p-t),abs(o-t)),t)