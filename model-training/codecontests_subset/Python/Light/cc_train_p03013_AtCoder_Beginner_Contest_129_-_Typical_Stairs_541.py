MOD=10**9+7

N,_,*a = map(int, open(0).read().split())
A=set(a)
dp = [0 for _ in range(N+1)]
dp[:2] = 1, 0 if 1 in A else 1
for i in range(2,N+1):
    if i not in A:
        dp[i]=(dp[i-1]+dp[i-2])%MOD
    
print(dp[N])


