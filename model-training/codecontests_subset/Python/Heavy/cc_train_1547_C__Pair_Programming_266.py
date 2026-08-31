t=int(input())
for s in range(t):
    input()
    r=list(map(int,input().split()))
    n=r[1]+r[2]
    k=r[0]
    a=list(map(int,input().split()))
    b=list(map(int,input().split()))
    c=[]
    p,q=0,0
    flag=1
    for i in range(n):
        t=0
        if p<r[1]:
            if a[p]==0:
                c.append(a[p])
                p+=1
                k+=1
            elif a[p]<=k:
                c.append(a[p])
                p+=1
            else:
                t=1
        else:
            t=1
        if q<r[2] and t==1:
            if b[q]==0:
                c.append(b[q])
                k+=1
                q+=1
            elif (b[q])<=k:
                c.append(b[q])
                q+=1
    if flag==1 and len(c)==(n):
        for i in c:
            print(i,end=' ')
        print()
    else:
        print(-1)
