n,m=map(int,input().split())
mod=10**9+7
dp=[1]*(n+1)
for _ in range(m):
  dp[int(input())]=0
dp[1]*=dp[0]
for i in range(2,n+1):
  dp[i]*=dp[i-1]+dp[i-2]
print(dp[-1]%mod)