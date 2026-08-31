def dp(k,a,t):
    a=sorted(a)
    t=sorted(t)
    dp=[[float("inf")]*(len(a)+1) for i in range(len(t)+1)]
    dp[0][0]=0
    for i in range(len(t)):
        for j in range(len(a)+1):
            dp[i+1][j]=min(dp[i+1][j],dp[i][j])
            if j<len(a):
                dp[i+1][j+1]=min(dp[i+1][j+1],max(dp[i][j],abs(a[j]-t[i])+abs(t[i]-k)))
    return (dp[len(t)][len(a)])
 
 
a,b,c=map(int,input().strip().split())
lst=list(map(int,input().strip().split()))
lst2=list(map(int,input().strip().split()))
print(dp(c,lst,lst2))