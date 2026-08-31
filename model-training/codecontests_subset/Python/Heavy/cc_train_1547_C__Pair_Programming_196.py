for _ in range(int(input())):
    x= input()
    k,n,m = map(int,input().split())
    a = list(map(int,input().split()))
    b = list(map(int,input().split()))
    i,j=0,0
    ans = [0]*(n+m)
    for idx in range(n+m):
        if i==n:
            ans[idx]=b[j]
            j+=1
        elif j==m:
            ans[idx]=a[i]
            i+=1
        elif a[i]<b[j]:
            ans[idx]=a[i]
            i+=1
        else:
            ans[idx]=b[j]
            j+=1
    for i in ans:
        if i>k:
            ans=[-1]
            break
        if i==0:k+=1
    print(*ans)