N,M,*a=map(int,open(0).read().split())

dp=[1]*(N+1)

for i in a:
  	dp[i]=0

for n in range(2,N+1):
    dp[n]=(dp[n-1]+dp[n-2])%1000000007*dp[n]

print(dp[N])
    