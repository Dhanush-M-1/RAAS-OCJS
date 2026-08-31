MOD=10**9+7
n,m=map(int,input().split())
a=[0]*m
dp=[1]*(n+1)
for i in range(m):
    a[i]=int(input())
    dp[a[i]]=0
for i in range(2,n+1):
    if dp[i]==0:
        continue
    else:
        dp[i]=dp[i-1]+dp[i-2]
print(dp[n]%MOD)