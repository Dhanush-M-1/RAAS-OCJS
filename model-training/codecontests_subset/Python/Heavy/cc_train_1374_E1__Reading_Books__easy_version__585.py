for _ in range(1):
    n,k=map(int,input().split())
    al = []
    bo = []
    com = []
    for i in range(n):
        t,a,b=map(int,input().split())
        if a==b==1:
            com.append(t)
        else:
            if a==1:
                al.append(t)
            if b==1:
                bo.append(t)
    com.sort(reverse=True)
    al.sort(reverse=True)
    bo.sort(reverse=True)
    ans=0
    f=0
    while(k!=0):
        if len(al)>0 and len(bo)>0:
            c=al[-1]+bo[-1]
            if len(com)>0 and c>com[-1]:
                ans+=com[-1]
                com.pop()
            else:
                ans+=c
                al.pop()
                bo.pop()
        elif len(com)>0:
            ans += com[-1]
            com.pop()
        else:
            f=1
            k=1
        k-=1
    if f==0:
        print(ans)
    else:
        print(-1)

