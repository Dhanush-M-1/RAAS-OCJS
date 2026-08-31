n,m,*a=map(int,open(0).read().split())
dp=[-1]*(n+1)
for i in a:
    dp[i]=0
dp[0]=1 
for i in range(1,n+1):
    if dp[i]!=0:
        dp[i]=dp[i-1]+dp[i-2]*(i>1)
print(dp[-1]%(10**9+7))