N, M = [int(x) for x in input().split()]

dp = [1] * (N + 1)

for i in range(M):
	dp[int(input())] = 0

if N == 1:
	print(1)
else:
	for i in range(N - 1):
		dp[i + 2] = (dp[i] + dp[i + 1]) * dp[i + 2]
	print(dp[N] % 1000000007)