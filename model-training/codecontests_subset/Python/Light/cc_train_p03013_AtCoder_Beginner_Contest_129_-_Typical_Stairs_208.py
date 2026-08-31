N, M = map(int, input().split())
A = set([int(input()) for _ in range(M)])

mod = 1000000007

dp = [0] * (N + 2)
dp[N] = 1  # GOAL

for i in range(N-1, -1, -1):
  if i not in A:
    dp[i] = dp[i+1] + dp[i+2]

print(dp[0] % mod)
