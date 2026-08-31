n,m=map(int,input().split())
mod=10**9+7
dp=[1]*(n+1)
for _ in range(m):
    i=int(input())
    dp[i]=0
for i in range(n+1):
    if dp[i]==0 or i < 2: continue
    else: dp[i]=(dp[i-1]+dp[i-2])%mod
print(dp[-1])