n = int(input())
pos = []
h = []
for i in range(n):
    position, height = map(int, input().split())
    pos.append(position)
    h.append(height)

dp = [[0] * n for i in range(3)]
dp[0][0] = 1
if n >= 2:
    dp[1][0] = 1 if pos[0] + h[0] < pos[1] else 0

for i in range(1, n):
    # Stay
    dp[2][i] = max(dp[2][i - 1], dp[1][i - 1], dp[0][i - 1])
    # Left
    dp[0][i] = dp[0][i - 1]
    if pos[i] - h[i] > pos[i - 1]:
        dp[0][i] = 1 + max(dp[2][i - 1], dp[0][i - 1])
    if pos[i] - h[i] > pos[i - 1] + h[i - 1]:
        dp[0][i] = max(dp[0][i], dp[1][i - 1] + 1)
    # Right
    if i < n - 1 and pos[i] + h[i] >= pos[i + 1]:
        continue
    dp[1][i] = 1 + max(dp[0][i - 1], dp[1][i - 1], dp[2][i - 1])

print(max(dp[0][n - 1], dp[1][n - 1], dp[2][n - 1]))
