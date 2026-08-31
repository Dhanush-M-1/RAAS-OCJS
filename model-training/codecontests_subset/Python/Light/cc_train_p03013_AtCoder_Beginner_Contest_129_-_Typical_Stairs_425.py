n,m=map(int,input().split())
dp=[0 for i in range(n+1)]
dp[0]=1
for i in range(m):
    dp[int(input())]="b"
for i in range(1,n+1):
    if(dp[i]=="b"):
        dp[i]=0
    else:
        dp[i]=dp[i-1]+dp[i-2]
print(dp[n]%1000000007)