n,m=map(int,input().split())
dp=[0]*(n+1)
for i in range(m):dp[int(input())]=-1
dp[0]=1
if dp[1]!=-1:dp[1]=1
for i in range(2,n+1):
    if dp[i]==0:dp[i]=(max(dp[i-2],0)+max(dp[i-1],0))%(10**9+7)
print(dp[-1])