N,M=map(int,input().split())
mod=10**9+7
a=[int(input()) for _ in range(M)]
dp=[1]*(N+1)
for i in a: dp[i]=0
for i in range(2,N+1):
    dp[i]=(dp[i-1]+dp[i-2])%mod*dp[i]
print(dp[-1])
