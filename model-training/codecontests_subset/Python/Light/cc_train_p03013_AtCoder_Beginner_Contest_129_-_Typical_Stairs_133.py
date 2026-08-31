N,M=map(int,input().split())
dp=[1]*(N+1)
for _ in range(M):
    a=int(input())
    dp[a]=0
for i in range(2,N+1):
    if dp[i]!=0:
        dp[i]=dp[i-1]+dp[i-2]
print(dp[N]%(10**9+7))