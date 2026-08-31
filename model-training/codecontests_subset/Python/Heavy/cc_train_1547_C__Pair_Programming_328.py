for _ in range(int(input())):
    s=input()
    k,n,m=map(int,input().split())
    a=list(map(int,input().split()))
    b=list(map(int,input().split()))
    l1=0
    l2=0
    ans=[]
    flag=0
    while l1<n and l2<m:
        if a[l1]<=k and b[l2]<=k:
            if a[l1]==0:
                ans.append(a[l1])
                k=k+1
                l1=l1+1
            else:
                ans.append(a[l1])
                l1=l1+1
        elif a[l1]<=k:
            if a[l1]==0:
                ans.append(a[l1])
                k=k+1
                l1=l1+1
            else:
                ans.append(a[l1])
                l1=l1+1
        elif b[l2]<=k:
            if b[l2]==0:
                ans.append(b[l2])
                k=k+1
                l2=l2+1
            else:
                ans.append(b[l2])
                l2=l2+1
        else:
            flag=1
            break
    if flag==1:
        print(-1)
    else:
        while l1<n:
            if a[l1]==0:
                k=k+1
                ans.append(a[l1])
                l1=l1+1
            elif a[l1]<=k:
                ans.append(a[l1])
                l1=l1+1
            else:
                print(-1)
                flag=1
                break
        while l2<m:
            if b[l2]==0:
                k=k+1
                ans.append(b[l2])
                l2=l2+1
            elif b[l2]<=k:
                ans.append(b[l2])
                l2=l2+1
            else:
                print(-1)
                flag=1
                break
        if flag==0:
            print(*ans)



