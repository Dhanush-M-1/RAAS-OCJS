N = input()
K = int(input())
dp= [[[0]*2 for i in range(len(N)+1)] for _ in range(len(N)+1)]
if len(N)<K:
  print(0)
  exit()
dp[0][0][0]=1
for i in range(len(N)):
  for j in range(len(N)):
    if int(N[i])!=0:
      dp[i+1][j+1][1]+=dp[i][j][1]*9+dp[i][j][0]*(int(N[i])-1)
      dp[i+1][j][1] += dp[i][j][1]+dp[i][j][0]
      dp[i+1][j+1][0] += dp[i][j][0] 
    if int(N[i])==0:
      dp[i+1][j+1][1] += dp[i][j][1]*9
      dp[i+1][j][1] += dp[i][j][1]
      dp[i+1][j][0] += dp[i][j][0]
print(dp[len(N)][K][0]+dp[len(N)][K][1])