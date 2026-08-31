MOD=10**9+7
n,m=map(int,input().split())
a=[int(input()) for _ in range(m)]
dp=[0]*(n+1)
dp[0]=1
dp[1]=1 if 1 not in a else 0
a=sorted(list(set(range(2,n+1))-set(a)))
for i in a:
    dp[i]=(dp[i-1]+dp[i-2])%MOD
print(dp[n]%MOD)