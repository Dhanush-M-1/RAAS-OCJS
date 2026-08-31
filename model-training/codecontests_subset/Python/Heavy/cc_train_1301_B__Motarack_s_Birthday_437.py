k=int(input())
for i in range(k):
    n1=int(input())
    a=list(map(int,input().split()))
    m=min(a)
    n=max(a)
    d=0
    for j in range(n1):
       if a[j]!=-1: 
        if j!=0 and a[j-1]==-1:
            m=max(m,a[j])
            n=min(n,a[j])
        elif j!=n1-1 and a[j+1]==-1:
            m=max(m,a[j])
            n=min(n,a[j])
            
       if j>0 and a[j]!=-1 and a[j-1]!=-1:
            d=max(d,abs(a[j]-a[j-1]))
            
    
    s=m+n
    s=s//2
    d=max(abs(s-m),abs(s-n),d)
    if m==n==-1:
        print(0,0)
    else:
        print(d,s)
