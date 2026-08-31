t=int(input())
for _ in range(t):
    n=int(input())
    a=list(map(int,input().split()))
    b=[]
    for i in range(n):
        b.append(a[i])
    s=set()
    for i in range(n):
        if a[i]==-1:
            if i>0 and i<n-1:
                if a[i-1]!=-1:
                    s.add(a[i-1])
                if a[i+1]!=-1:
                    s.add(a[i+1])
            elif i==0:
                if a[i+1]!=-1:
                    s.add(a[i+1])
            elif i==n-1:
                if a[i-1]!=-1:
                    s.add(a[i-1])
    if len(s)==0:
        k=0
        m=0
        for i in range(n):
            if a[i]==-1:
                a[i]=k
        for i in range(1,n):
            m=max(m,abs(a[i]-a[i-1]))
        print(m,k)
    else:
        k=(max(s)+min(s))//2
        m=0
        for i in range(n):
            if a[i]==-1:
                a[i]=k
        for i in range(1,n):
            m=max(m,abs(a[i]-a[i-1]))
        print(m,k)