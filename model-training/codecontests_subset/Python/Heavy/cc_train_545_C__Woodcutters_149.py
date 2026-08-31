n = int(input())
co = []
h = []
for _ in range(n):
    x,h2 = map(int,input().split())
    co.append(x)
    h.append(h2)
co.append(10**10)
dp = [[0]*3 for _ in range(n)]
dp[0][0] = 1
dp[0][1] = 1
dp[0][2] = 0
for i in range(1,n):
    if co[i] - h[i] > co[i-1] + h[i-1]:
        dp[i][0] = 1 + max(dp[i-1][0],dp[i-1][1],dp[i-1][2])
    elif co[i] - h[i] > co[i-1]:
        dp[i][0] = 1 + max(dp[i-1][0],dp[i-1][2])
    else:
        dp[i][0] = max(dp[i-1][0],dp[i-1][1],dp[i-1][2])
    if co[i] > co[i-1] + h[i-1] and co[i] + h[i] < co[i+1]:
        dp[i][1] = 1 + max(dp[i-1][0],dp[i-1][1],dp[i-1][2])
    elif co[i] > co[i-1] and co[i] + h[i] < co[i+1]:
        dp[i][1] = 1 + max(dp[i-1][0],dp[i-1][2])
    else:
        dp[i][1] = max(dp[i-1][0],dp[i-1][1],dp[i-1][2])
    dp[i][2] = max(dp[i-1][0],dp[i-1][1],dp[i-1][2])
print(max(dp[n-1][0],dp[n-1][1],dp[n-1][2]))