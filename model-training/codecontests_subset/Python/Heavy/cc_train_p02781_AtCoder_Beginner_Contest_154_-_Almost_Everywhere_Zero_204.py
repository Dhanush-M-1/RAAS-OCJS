n=input()
k=int(input())
m=len(n)
dp=[[[0]*(k+1) for _ in range(2)] for _ in range(m+1)]
dp[0][0][0]=1
for i in range(1,m+1):
    l = int(n[i-1])
    for j in range(k+1):
        dp[i][1][j]+=dp[i-1][1][j] 
        if l!=0:
            dp[i][1][j]+=dp[i-1][0][j]  
        else:
            dp[i][0][j]+=dp[i-1][0][j]      
        if j-1>=0:
            dp[i][1][j]+=9*dp[i-1][1][j-1]
            if l!=0:
                dp[i][0][j]+=dp[i-1][0][j-1]
                dp[i][1][j]+=(l-1)*dp[i-1][0][j-1]
print(dp[m][0][k]+dp[m][1][k])