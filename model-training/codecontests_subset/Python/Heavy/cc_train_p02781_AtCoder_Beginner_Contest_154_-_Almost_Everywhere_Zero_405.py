# -*- coding: utf-8 -*-
n = input()
K = int(input())
l = len(n)
dp = [[[0 for _ in range(5)] for _ in range(2)] for _ in range(l+1)]
dp[0][0][0] = 1
for i in range(l):
    D = int(n[i])
    for j in range(2):
        for k in range(4):
            for d in range((9 if j==1 else D)+1):
                J = j==1 or d<D
                if d!=0:
                    dp[i+1][1 if J else 0][k+1] += dp[i][j][k]
                else:
                    dp[i+1][1 if J else 0][k] += dp[i][j][k]

print(dp[l][0][K]+dp[l][1][K])