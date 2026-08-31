n=input()
k=int(input())


dp=[[[0]*2 for i in range(k+2)] for j in range(len(n)+1)]
dp[0][0][0]=1


for i in range(len(n)):
  x=int(n[i])
  for j in range(k+1):
    
    if x==0:
      dp[i+1][j][0]+=dp[i][j][0]
    else:
      dp[i+1][j+1][0]+=dp[i][j][0]

    dp[i+1][j][1]+=dp[i][j][1]    #０
    if x!=0:
      dp[i+1][j][1]+=dp[i][j][0]    #０
    
    dp[i+1][j+1][1]+=dp[i][j][1]*9    #1~9

    if x!=0:
      dp[i+1][j+1][1]+=dp[i][j][0]*max(x-1,0)    #1~x-1


print(dp[-1][k][0]+dp[-1][k][1])