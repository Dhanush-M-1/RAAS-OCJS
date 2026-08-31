n = input()
num_list = list(map(int, n))
k = int(input())

dp = [[[0] * (k+2) for _ in range(2)] for _ in range(len(n)+1)]
dp[0][0][0] = 1
for i, v in enumerate(num_list):
    for j in range(k+1):
        dp[i+1][1][j] += dp[i][1][j]
        dp[i+1][1][j+1] += dp[i][1][j] * 9

        if v == 0:
            dp[i+1][0][j] += dp[i][0][j]
        else:
            dp[i+1][1][j+1] += dp[i][0][j] * (v - 1)
            dp[i+1][1][j] += dp[i][0][j]
            dp[i+1][0][j+1] += dp[i][0][j]

print(dp[len(n)][0][k] + dp[len(n)][1][k])