n = int(input())

x, h = [], []

for i in range(n):
    xv, hv = map(int, input().split())
    x.append(xv)
    h.append(hv)

dp = [[0] * n for _ in range(3)]

dp[0][0] = 0
dp[1][0] = 1
if len(x) > 1 and x[0] + h[0] < x[1]:
    dp[2][0] = 1
else:
    dp[2][0] = 0

for i in range(1, n):
    prev_max = max(max(dp[0][i - 1], dp[1][i - 1]), dp[2][i - 1])
    dp[0][i] = prev_max

    if x[i - 1] < x[i] - h[i]:
        dp[1][i] = max(dp[0][i - 1], dp[1][i - 1]) + 1
        if x[i - 1] + h[i - 1] < x[i] - h[i]:
            dp[1][i] = max(dp[1][i], dp[2][i - 1] + 1)
    else:
        dp[1][i] = prev_max

    dp[2][i] = prev_max
    if i + 1 < n and x[i] + h[i] < x[i + 1]:
        dp[2][i] += 1
    elif i == n - 1:
        dp[2][i] += 1

print(max(max(dp[0][n - 1], dp[1][n - 1]), dp[2][n - 1]))
