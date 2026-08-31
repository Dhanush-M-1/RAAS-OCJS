t=int(input())
for _ in range(t):
    n=int(input())
    a=list(map(int,input().split()))
    if a.count(-1)==len(a):
        print(0,1)
    else:
        d=list()
        for i in range(n):
            if i+1 < n and a[i]==-1 and a[i+1]!=-1:
                d.append(a[i+1])
            if i-1 >=0 and a[i]==-1 and a[i-1]!=-1:
                d.append(a[i-1])
        m=0
        for  i in range(n-1):
            if a[i]!=-1 and a[i+1]!=-1:
                m=max(m,abs(a[i]-a[i+1]))
        d.sort()
        s=d[-1]+d[0]
        if s%2==0:
            k=s//2
            for  i in range(n):
                if a[i]==-1:
                    a[i]=k
            for i in range(1,n):
                m=max(m,abs(a[i]-a[i-1]))
            print(m,k)
        else:
            t1=s//2
            t2=t1+1
            v=a.copy()
            for  i in range(n):
                if a[i]==-1:
                    a[i]=t1
                if v[i]==-1:
                    v[i]=t2
            q=m
            for i in range(1,n):
                m=max(m,abs(a[i]-a[i-1]))
                q=max(q,abs(v[i]-v[i-1]))
            if m<q:
                print(m,t1)
            else:
                print(q,t2)