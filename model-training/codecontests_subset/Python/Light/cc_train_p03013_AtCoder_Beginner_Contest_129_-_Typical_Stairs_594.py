N,M=map(int,input().split())
A=[int(input()) for i in range(M)]
dp=[1]*(N+1)
for i in A:
  dp[i]=0

for i in range(2,N+1):
  if dp[i]==1:
    dp[i]=(dp[i-1]+dp[i-2])%(10**9+7)

print(dp[N])