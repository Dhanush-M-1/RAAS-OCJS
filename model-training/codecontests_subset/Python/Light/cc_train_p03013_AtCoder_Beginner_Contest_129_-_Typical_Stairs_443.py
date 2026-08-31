mod = 10**9 + 7
n,m = map(int,input().split())
dp = [1] * (n+1)
for _ in range(m):
    a = int(input())
    dp[a] = 0
for i in range(0,n-1):
    dp[i+2] = dp[i+2] * (dp[i+1] + dp[i])%mod
print(dp[-1])
