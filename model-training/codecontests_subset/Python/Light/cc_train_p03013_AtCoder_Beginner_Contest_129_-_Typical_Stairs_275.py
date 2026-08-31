n,m=[int(i) for i in input().split()]
a=[int(input()) for _ in range(m)]
dp=[1]+[1]*100010
for i in a:
    dp[i]=0
for i in range(2,n+1):
    if dp[i]:
        dp[i]=dp[i-1]+dp[i-2]
print(dp[n]%1000000007)