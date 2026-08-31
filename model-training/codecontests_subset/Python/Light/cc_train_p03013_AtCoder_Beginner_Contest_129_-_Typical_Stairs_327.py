INIT = 1
n, m = map(int, input().split())
dp = [INIT for i in range(n + 1)]

for i in range(m):
    a = int(input())
    dp[a] = 0

for i in range(2, n + 1):
    dp[i] = (dp[i - 1] + dp[i - 2]) * dp[i]

print(dp[n] % 1000000007)
