n = int(input())
x, h = zip(*[map(int, input().split()) for i in range(n)])
dp = [[0,1,1]]
for i in range(1,n):
    z = [max(dp[i-1][0], dp[i-1][1]),0,0]
    if x[i] - x[i-1] >= h[i-1]+1 : z[0] = max(z[0], dp[i-1][2])
    if x[i] - x[i-1] >= h[i]+1 : z[1] = 1+max(dp[i-1][0], dp[i-1][1])
    if x[i] - x[i-1] >= h[i]+h[i-1]+1 : z[1] = max(z[1], 1 + dp[i-1][2])
    z[2] = z[0]+1
    dp.append(z)
print(dp[n-1][2])
