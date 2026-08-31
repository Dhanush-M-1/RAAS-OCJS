n,m=map(int,input().split())
a=[int(input()) for _ in range(m)]

INF=1000000007
dp=[1]*(n+1)

for item in a:
    dp[item]=0
for i in range(2,n+1):
    if dp[i]==0:
        continue
    dp[i]=dp[i-2]+dp[i-1]

print(dp[-1]%INF)
