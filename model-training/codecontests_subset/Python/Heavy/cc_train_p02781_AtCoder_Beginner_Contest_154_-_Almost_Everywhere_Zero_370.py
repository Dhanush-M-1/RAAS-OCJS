N=input()
l=len(N)
K=int(input())
dp=[[[0 for i in range(4)] for i in range(2)] for i in range(l+1)]
dp[0][0][0]=1
for i in range(l):
    for smaller in range(2):
        for c in range(4):
            lim=9 if smaller else int(N[i])
            for d in range(lim+1):
                if(c!=3):
                    dp[i+1][smaller or d<lim][c+(d!=0)]+=dp[i][smaller][c]
                else:
                    if(d==0):
                        dp[i+1][smaller or d<lim][c]+=dp[i][smaller][c]

print(dp[l][0][K]+dp[l][1][K])