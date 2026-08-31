n, m = map(int, input().split())
mod = 10**9 + 7
dp = [1]*(n+1)
 
for _ in range(m):
    a = int(input())
    dp[a] = 0
 
for i in range(2, n+1):
    if dp[i]>0:
        dp[i] = (dp[i-1]+dp[i-2])%mod
 
print(dp[n])