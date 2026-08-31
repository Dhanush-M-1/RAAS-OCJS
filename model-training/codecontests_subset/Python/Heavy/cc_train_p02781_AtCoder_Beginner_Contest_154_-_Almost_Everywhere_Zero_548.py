n="0"+input()
k=int(input())
dp=[[[0]*5,[0]*5] for _ in range(len(n))]
dp[0][1][0]=1
for i in range(1,len(n)):
    x=int(n[i])
    for j in range(4):
        if dp[i-1][1][j]:
            dp[i][1][j+(x!=0)]=1
            if x>1:
                dp[i][0][j+1]+=(x-1)
                dp[i][0][j]+=1
            elif x==1:
                dp[i][0][j]+=1
        if dp[i-1][0][j]:
            dp[i][0][j]+=dp[i-1][0][j]
            dp[i][0][j+1]+=(dp[i-1][0][j]*9)
    dp[i][0][0]=1

print(dp[-1][0][k]+dp[-1][1][k])