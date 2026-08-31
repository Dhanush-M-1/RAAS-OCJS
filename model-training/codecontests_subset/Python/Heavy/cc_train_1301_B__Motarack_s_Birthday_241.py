t = int(input())
for o in range(t):
    n = int(input())
    a = list(map(int, input().split()))
    m1=max(a)+1
    m2=0
    for i in range(n):
        if a[i]!=-1:
            if i+1<n:
                if a[i+1]==-1:
                    if a[i]<m1:
                        m1=a[i]
                    if a[i]>m2:
                        m2=a[i]
            if i-1>=0:
                if a[i-1]==-1:
                    if a[i]<m1:
                        m1=a[i]
                    if a[i]>m2:
                        m2=a[i]
    k=(m1+m2)//2
    m=0
    if a[0]==-1:
        a[0]=k
    for i in range(1,n):
        if a[i]==-1:
            a[i]=k
        m=max(m,abs(a[i]-a[i-1]))
    print(m,k)