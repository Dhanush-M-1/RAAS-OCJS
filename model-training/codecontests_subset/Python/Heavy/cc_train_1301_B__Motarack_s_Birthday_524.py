
t=int(input())
for _ in range(t):
    n=int(input())
    diff=[]
    z=[]
    l=list(map(int,input().split()))
    if(l.count(-1)==n):
        print(0,10)

    else:
        for i in range(len(l)-1):
            if(l[i]!=-1 and l[i+1]!=-1):
                diff.append(abs(l[i]-l[i+1]))
        for i in range(1,n-1):
            if(l[i]!=-1) and (l[i-1]==-1 or l[i+1]==-1):
                z.append(l[i])
        if(l[1]==-1 and l[0]!=-1):
            z.append(l[0])
        if(l[-2]==-1 and l[-1]!=-1):
            z.append(l[-1])
        if(len(diff)!=0):
            d=max(diff)
        else:
            d=0
        a=max(z)
        b=min(z)
        c=(a+b)//2
        m=max(abs(a-c),abs(b-c),d)
        print(m,c)