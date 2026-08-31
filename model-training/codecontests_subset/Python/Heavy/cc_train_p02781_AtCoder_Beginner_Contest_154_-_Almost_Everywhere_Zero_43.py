x = int(input())
X = [int(i) for i in str(x)]
y = int(input())
dp = [[[0] * 2 for i in range(4)] for j in range(len(str(x))+1)]
dp[0][0][0] = 1

for i in range(len(str(x))):
  for j in range(4):
    for m in range(2):
      for n in range(10):
        nj = j + 1 if n != 0 else j
        if nj == 4: continue
        nm = m        
        if X[i] > n and m == 0:
          nm = 1
        if X[i] < n and m == 0:
          continue
        dp[i+1][nj][nm] += dp[i][j][m]

print(dp[len(X)][y][0]+dp[len(X)][y][1])
