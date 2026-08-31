n = input()
l = len(n)
k = int(input())
dp = [[[0] * 2 for _ in range(k + 1)] for _ in range(l + 1)]
dp[0][k][1] = 1
for i in range(l):
  for j in range(k+1):
    if n[i] != '0':
      if j >= 1:
        dp[i+1][j-1][0] += dp[i][j][0]*9 + dp[i][j][1]*(int(n[i])-1)
        dp[i+1][j-1][1] += dp[i][j][1]
      dp[i+1][j][0] += dp[i][j][1] + dp[i][j][0]
    else:
      if j >= 1:
        dp[i+1][j-1][0] += dp[i][j][0]*9 
      dp[i+1][j][0] += dp[i][j][0]
      dp[i+1][j][1] += dp[i][j][1]
      
print(dp[l][0][0]+dp[l][0][1])