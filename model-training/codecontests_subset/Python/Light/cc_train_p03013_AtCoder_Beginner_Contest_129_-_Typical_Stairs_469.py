N,M = map(int,input().split())
A = set(int(input()) for m in range(M))
dp = (N+1)*[0]
dp[0] = 1

for n in range(1,N+1):
  if n not in A:
    dp[n] = (dp[n-2]+dp[n-1])%(10**9+7)

print(dp[-1])