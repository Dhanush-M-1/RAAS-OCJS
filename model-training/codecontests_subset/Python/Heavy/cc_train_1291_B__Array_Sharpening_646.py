t=int(input())
for _ in range(t):
    n=int(input())
    a=list(map(int,input().split()))
    dp=[0]*(n)
    dp[0]=1
    p=1
    for i in range(1,n):
        if a[i]>=p:
            dp[i]=1
            p+=1
        else:
            break
    
    dp1=[0]*n
    dp1[n-1]=1
    p=1
    for i in range(n-2,-1,-1):
        if a[i]>=p:
            dp1[i]=1
            p+=1
        else:
            break
    tf=False
    for i in range(n):
        if dp[i]==1 and dp1[i]==1:
            tf=True
            break
    if tf:
        print('YES')
    else:
        print('NO')