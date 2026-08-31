n,m=map(int,input().split())
inf=1000000007
ans=1
dp=[1]*(n+1)
for i in range(m):
    dp[int(input())]=0
for i in range(n-1):
    dp[i+2]=(dp[i]+dp[i+1])*dp[i+2]
print(dp[-1]%inf)