n,m=map(int,input().split())
mod=10**9+7
dp=[0]*(n+1)
dp[0]=1
a=set([int(input()) for _ in range(m)])

for i in range(1,n+1):
    if i in a:
        dp[i]=0
    else:
        dp[i]=dp[i-1]+dp[i-2]
        dp[i]%=mod
print(dp[n])