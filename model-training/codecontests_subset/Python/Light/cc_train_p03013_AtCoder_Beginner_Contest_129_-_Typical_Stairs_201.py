n,m = map(int,input().split())
dp = [1]*(n+1)

for _ in range(m):
    idx = int(input())
    dp[idx] = 0
for i in range(2,n+1):
    if dp[i] != 0:
        dp[i] = dp[i-1] + dp[i-2]
print(dp[-1]%1000000007)