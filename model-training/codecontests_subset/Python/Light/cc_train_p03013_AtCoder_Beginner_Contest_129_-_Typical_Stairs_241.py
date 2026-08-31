n,m=map(int,input().split())
a={int(input()) for i in range(m)}
mod=10**9+7

x=1 if 1 not in a else 0
dp=[1,x]+[0]*(n-1)

for i in range(2,n+1):
    if i in a:
        continue
    dp[i]=(dp[i-1]+dp[i-2])
print(dp[-1]%mod)
