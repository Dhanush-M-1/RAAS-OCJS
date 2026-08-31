n,m = map(int,input().split())
A = set([int(input()) for i in range(m)])
mod = 10**9+7

dp = [0]*(n+2)
dp[1]=1

for i in range(2,n+2):
    if i-1 not in A:
        dp[i]=dp[i-1]%mod+dp[i-2]%mod
print(dp[n+1]%mod)