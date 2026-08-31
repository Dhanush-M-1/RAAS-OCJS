N,M=map(int,input().split())
br=set([int(input()) for _ in range(M)])
dp=[0]*(N+1)
dp[0]=1
if not 1 in br:
    dp[1]=1
for i in range(2,N+1):
    if not i in br:
        dp[i]+=(dp[i-1]+dp[i-2])%1000000007
print(dp[-1])
