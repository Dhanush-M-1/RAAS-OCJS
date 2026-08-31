N = int(input())
X = []
H = []
for i in range(N):
    x,h = map(int,input().split())
    X.append(x)
    H.append(h)
dp = [[1 for i in range(3)] for j in range(N)]
# 0 means straight
# 1 means left 
# 2 means right
for i in range(1,N):
    # Straight
    if(X[i-1] + H[i-1]<X[i]):
        dp[i][0] = dp[i-1][2]
    else:
        dp[i][0] = dp[i-1][0]
    # LEft 
    if(X[i-1] + H[i-1] < X[i] - H[i]):
        dp[i][1] = dp[i-1][2] + 1
    elif(X[i]-H[i] > X[i-1]):
        dp[i][1] = max(dp[i-1][0] + 1, dp[i-1][1] + 1)
    else:
        dp[i][1] = max(dp[i-1][0],dp[i-1][1])  # Here may be bug
    # Right
    if(X[i-1] + H[i-1] < X[i]):
        dp[i][2] = dp[i-1][2] + 1
    else:
        dp[i][2] = max(dp[i-1][0] + 1,dp[i-1][1] + 1)
print(max(dp[-1][0],dp[-1][1],dp[-1][2]))
