n=input()
kk=int(input())

l=len(n)

dp=[[[0]*2 for _ in range(101)] for _ in range(l+1)]
dp[0][0][0]=1

for i,dig in enumerate(n):
    dig=int(dig)

    for j in range(10):
        for k in range(100):
            nk=k if j==0 else k+1
            if j<dig:
                dp[i+1][nk][1]+=dp[i][k][0]+dp[i][k][1]
            elif j==dig:
                dp[i+1][nk][1]+=dp[i][k][1]
                dp[i+1][nk][0]+=dp[i][k][0]
            else:
                dp[i+1][nk][1]+=dp[i][k][1]

print(dp[l][kk][0]+dp[l][kk][1])