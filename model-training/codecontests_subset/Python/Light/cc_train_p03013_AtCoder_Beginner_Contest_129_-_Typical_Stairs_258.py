n,m = map(int,input().split())
mod = 10**9+7
dp = [1]*(n+1)
for i in range(m):
    dp[int(input())] =0

for i in range(2,n+1):
    if dp[i]!=0:
        dp[i]=dp[i-1]+dp[i-2]

print(dp[n]%mod)
