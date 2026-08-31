n = int(input())
x = [list(map(int, input().split())) for i in range(n)]

if n == 1:
    print(n)
    quit()

dp = [[0]*2 for i in range(n)]
dp[0][0] = 1

for i in range(1, n-1):
    a = x[i-1][0]
    b = x[i][0]
    c = x[i+1][0]
    if b-a > x[i][1]:
        dp[i][0] = dp[i-1][0] + 1
        if b-a > x[i][1] + x[i-1][1]:
            dp[i][0] = max(dp[i][0], dp[i-1][1]+1)
    if c-b > x[i][1]:
        dp[i][1] = max(dp[i-1][0],dp[i-1][1])+1
    dp[i][0] = max(dp[i][0], dp[i-1][0], dp[i-1][1])
print(max(dp[n-2][0], dp[n-2][1])+1)