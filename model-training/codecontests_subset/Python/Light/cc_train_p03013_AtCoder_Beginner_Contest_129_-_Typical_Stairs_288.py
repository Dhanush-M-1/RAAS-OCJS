n,m,*a=map(int,open(0).read().split())
dp=[-1]*(n+1)+[0]
for i in a:
    dp[i]=0
dp[0]=1
for i in range(1,n+1):
    if dp[i]==-1:
        dp[i]=dp[i-1]+dp[i-2]
print(dp[-2]%1000000007)