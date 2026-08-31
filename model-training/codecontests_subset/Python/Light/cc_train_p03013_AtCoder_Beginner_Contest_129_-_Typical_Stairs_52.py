n, m = map(int, input().split())
dp = [-1]*(n+1)
for i in range(m):
    dp[int(input())] = 0
dp[0] = 1
if dp[1] != 0:
    dp[1] = 1
for i in range(2,n+1):
    if dp[i] != 0:
        dp[i] = (dp[i-1]+dp[i-2])%1000000007
print(dp[n])