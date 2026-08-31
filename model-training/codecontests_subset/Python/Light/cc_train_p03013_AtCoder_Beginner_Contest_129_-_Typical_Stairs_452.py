N,M=map(int,input().split())
dp=[1]*(N+1)
for _ in range(M):
  i=int(input())
  dp[i]=0
for i in range(2,N+1):
  if dp[i]!=0:
      dp[i]=dp[i-1]+dp[i-2]
  dp[i]%=1000000007
print(dp[N])


