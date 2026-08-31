n,m=map(int,input().split())
a=[int(input()) for _ in range(m)]
dp=[1]*(n+1)
for i in a:
  dp[i]=0
for i in range(2,n+1):
  dp[i]=(dp[i-1]+dp[i-2])%1000000007*dp[i]
print(dp[-1])