MOD = 10**9+7
n, m = map(int, input().split())
a = [int(input()) for _ in range(m)]
a = set(a)
dp = [0] * (n+1)
dp[0] = 1
for i in range(1, n+1):
    if i not in a:
        dp[i] = (dp[i-1] + dp[i-2]) % MOD
print(dp[n])