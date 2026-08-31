n="0"+input()
k=int(input())
dp=[[[0]*(k+1) for i in range(len(n))] for _ in range(2)]
dp[0][0][0]=1
dp[1][1][0]=1
for i in range(1,len(n)):
    x=int(n[i])
    dp[1][i][0]+=dp[1][i-1][0]
    for j in range(1,k+1):
        if x==0:
            dp[0][i][j]+=dp[0][i-1][j]
            dp[1][i][j]+=dp[1][i-1][j]+dp[1][i-1][j-1]*9
        else:
            dp[0][i][j]+=dp[0][i-1][j-1]
            dp[1][i][j]+=dp[1][i-1][j]+dp[1][i-1][j-1]*9+dp[0][i-1][j-1]*(x-1)+dp[0][i-1][j]
print(dp[1][-1][-1]+dp[0][-1][-1])