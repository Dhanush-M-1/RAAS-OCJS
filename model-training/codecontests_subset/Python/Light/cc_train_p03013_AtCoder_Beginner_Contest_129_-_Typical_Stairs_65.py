n,m,*a=map(int,open(0).read().split())
a=set(a)
mod=10**9+7

dp=[0]*(n+1)

dp[0]=1
dp[1]=0 if 1 in a else 1

for st in range(2,n+1):
    if st in a:
        continue
    
    dp[st]=dp[st-1]+dp[st-2]
    dp[st]%=mod

print(dp[n])