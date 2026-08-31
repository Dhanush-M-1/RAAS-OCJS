N,M = map(int, input().split())
mod = 1000000007
dp = [1 for _ in range(N+1)]
for i in range(M):
	dp[int(input())] = 0
for i in range(2,N+1):
	if dp[i] != 0:
		dp[i] = (dp[i-1] + dp[i-2]) % mod
print(dp[N])