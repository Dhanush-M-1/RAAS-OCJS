t = int(input())
for _ in range(t):
    poem = input()
    n = len(poem)
    dp = [[[n + 1, n + 1] for _ in range(2)] for _ in range(n)]
    for i in range(2):
        for j in range(2):
            dp[0][i][j] = j
    for i in range(1, n):
        if poem[i] == poem[i-1] == poem[i-2] and i > 1:
            dp[i][0][1] = dp[i-1][1][0] + 1
            dp[i][1][1] = min(dp[i-1][0][1], dp[i-1][1][1]) + 1
            dp[i][1][0] = dp[i-1][1][1]
        elif poem[i] == poem[i-2] and poem[i] != poem[i-1] and i > 1:
            dp[i][0][0] = dp[i-1][1][0]
            dp[i][0][1] = min(dp[i-1][1][0], dp[i-1][0][0]) + 1
            dp[i][1][0] = dp[i-1][1][1]
            dp[i][1][1] = min(dp[i-1][0][1], dp[i-1][1][1]) + 1
        elif poem[i] == poem[i-1]:
            dp[i][0][1] = min(dp[i-1][0][0], dp[i-1][1][0]) + 1
            dp[i][1][0] = min(dp[i-1][1][1], dp[i-1][0][1])
            dp[i][1][1] = min(dp[i-1][0][1], dp[i-1][1][1]) + 1
        else:
            for j in range(2):
                for k in range(2):
                    dp[i][j][k] = min(dp[i][j][k], dp[i-1][0][j], dp[i-1][1][j]) + k
    ans = n + 1
    for i in range(2):
        for j in range(2):
            ans = min(ans, dp[-1][i][j])
    print(ans)
