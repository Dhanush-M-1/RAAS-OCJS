#q=int(input())
q=1
for Q in range(q):
    n,k=map(int,input().split())
    c01=[]
    c10=[]
    c11=[]
    for i in range(n):
        t,a,b=map(int,input().split())
        if(a==1 and b==0):
            c10.append(t)
        if(a==0 and b==1):
            c01.append(t)
        if(a==1 and b==1):
            c11.append(t)
    c01.sort()
    c10.sort()
    c11.sort()
    if(len(c10)+len(c11)<k or len(c01)+len(c11)<k):
        print(-1)
        continue
    sz=min(len(c01),len(c10))
    res=[]
    for i in range(sz):
        res.append(c01[i]+c10[i])
    for i in c11:
        res.append(i)
    res.sort()
    ans=0
    for i in range(k):
        ans+=res[i]
    print(ans)
        
    
