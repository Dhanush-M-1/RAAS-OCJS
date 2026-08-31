t=int(input())
for _ in range(t):
    n=int(input())
    a=list(map(int,input().split()))
    c=[]
    for i in range(1,n-1):
        if a[i]==-1:
            if a[i-1]!=-1:
                c.append(a[i-1])
            if a[i+1]!=-1:
                c.append(a[i+1])
    if a[-1]==-1 and a[-2]!=-1:
        c.append(a[-2])
    if a[0]==-1 and a[1]!=-1:
        c.append(a[1])
    if len(c)==0:
        print(0,1)
        continue
    else:    
        d=(max(c)+min(c))//2
    b=[]
    for i in range(n):
        if a[i]==-1:
            a[i]=d
    for i in range(n-1):
        b.append(abs(a[i+1]-a[i]))
    print(max(b),d)