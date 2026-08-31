n,m = map(int,input().split())
mod = int(1e9+7)
f = [True for i in range(n+1)]
for i in range(m):
	f[int(input())] = False
dp=[1]+[0 for i in range(n+1)]
for i in range(n):
	if f[i+1]:
		dp[i+1] = (dp[i]+dp[i-1])%mod
print(dp[n])