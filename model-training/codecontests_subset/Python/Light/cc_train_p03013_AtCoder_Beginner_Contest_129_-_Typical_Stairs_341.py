N, M = map(int,input().split())
a = [int(input()) for i in range(M)]

dp = [1]*(N+1)
mod = 10**9+7

for A in a:
    dp[A] = 0

for i in range(N+1):
    if i>=2 and dp[i]:
        dp[i] = (dp[i-1]+dp[i-2])%mod

print(dp[N])