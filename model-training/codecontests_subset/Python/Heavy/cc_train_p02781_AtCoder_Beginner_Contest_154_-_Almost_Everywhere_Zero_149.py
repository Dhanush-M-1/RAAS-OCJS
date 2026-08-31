s,k=input(),int(input())
n=[int(i) for i in s]
l=len(s)
dp=[[[0]*(k+1),[0]*(k+1)] for i in range(l+1)]
dp[0][0][0]=1
for i in range(l):
    for smaller in range(2):
        for x in range(10 if smaller else n[i]+1):
            if x==0:
                for y in range(k+1):
                    dp[i+1][smaller or x<n[i]][y]+=dp[i][smaller][y]
            else:
                for y in range(k):
                    dp[i+1][smaller or x<n[i]][y+1]+=dp[i][smaller][y]
print(dp[-1][0][-1]+dp[-1][1][-1])