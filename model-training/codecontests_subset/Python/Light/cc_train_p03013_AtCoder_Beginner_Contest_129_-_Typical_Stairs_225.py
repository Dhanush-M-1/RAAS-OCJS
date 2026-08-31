N,M = map(int, input().split())
dp = [1] * (N + 1)

for _ in range(M):
  a = int(input())
  dp[a] = 0

for i in range(2,N+1):
  if (1 == dp[i]):
    dp[i] = (dp[i-1] + dp[i-2]) % 1000000007


print(dp[-1])
