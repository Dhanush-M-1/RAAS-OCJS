n,m=map(int,input().split())
a=[int(input()) for i in range(m)]
dp=[1]*(n+1)
for i in a:
    dp[i]=0
    
k=10**9+7
for i in range(2,n+1):
    if dp[i]!=0:
        dp[i]=(dp[i-1]+dp[i-2])%k
        
print(dp[-1])
