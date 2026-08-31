MOD=10**9+7
N,M=map(int,input().split())
dp=[1]*(N+1)
for i in range(M):
  dp[int(input())]=0
for n in range(2,N+1):
  if dp[n]!=0:
    dp[n]=(dp[n-1]+dp[n-2])
print(dp[N]%MOD)
