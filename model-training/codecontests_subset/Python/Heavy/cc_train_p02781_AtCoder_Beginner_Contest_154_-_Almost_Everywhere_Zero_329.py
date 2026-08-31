S = input()
N = len(S)
K = int(input())

dp = [[[0, 0] for i in range(4)] for j in range(N+1)]
dp[0][0][0] = 1

for i in range(N):
    for j in range(4):
        for k in range(2):
            nd = int(S[i])
            for d in range(10):
                nj = j
                nk = k
                if d != 0: nj += 1
                if nj > K: continue
                if k == 0:
                    if d > nd: continue
                    if d < nd: nk = 1
                dp[i+1][nj][nk] += dp[i][j][k]

print(sum(dp[N][K]))