N = input()
K = int(input())

dp = [[[0 for _ in range(5)] for _ in range(2)] for _ in range(len(N)+1)]
dp[0][0][0] = 1

for i in range(len(N)):
    dgt = int(N[i])
    for k in range(K+1):
        dp[i+1][1][k+1] += dp[i][1][k] * 9
        dp[i+1][1][k] += dp[i][1][k]

        if dgt > 0:
            dp[i+1][1][k+1] += dp[i][0][k] * (dgt-1)
            dp[i+1][1][k] += dp[i][0][k]

            dp[i+1][0][k+1] = dp[i][0][k]
        else:
            dp[i+1][0][k] = dp[i][0][k]

print(dp[len(N)][0][K] + dp[len(N)][1][K])
