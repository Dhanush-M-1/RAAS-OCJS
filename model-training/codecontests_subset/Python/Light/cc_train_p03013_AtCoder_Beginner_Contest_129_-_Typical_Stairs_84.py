n,m=map(int,input().split())
l={int(input()) for i in range(m)}
dp=[0 for i in range(n+1)]
dp[0]=1
for i in range(1,1+n):
    if i not in l:dp[i]+=dp[i-1]+dp[i-2];dp[i]%=10**9+7
print(dp[n])