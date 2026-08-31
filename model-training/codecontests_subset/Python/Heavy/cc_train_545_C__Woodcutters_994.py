n = int(input())
x = []
h = []
for i in range(n):
    x_, h_ = list(map(int, input().split()))
    x.append(x_)
    h.append(h_)
dp = [[1, 1, 0]]
for i in range(1, n):
  dp.append([0, 0, 0])

  if x[i-1]+h[i-1]<x[i]-h[i]:
    dp[i][0] = max(dp[i-1][0], dp[i-1][1], dp[i-1][2])+1 
  elif x[i]-h[i] <= x[i-1]:
    dp[i][0] = 0
  else:
    dp[i][0] = max(dp[i-1][0], dp[i-1][2])+1 

  if x[i-1]+h[i-1]<x[i]:
    dp[i][1] = max(dp[i-1][0], dp[i-1][1], dp[i-1][2])+1 
  else:
    dp[i][1] = max(dp[i-1][0], dp[i-1][2])+1 
  
  if x[i-1]+h[i-1]<x[i]:
    dp[i][2] = max(dp[i-1][0], dp[i-1][1], dp[i-1][2])
  else:
    dp[i][2] = max(dp[i-1][0], dp[i-1][2])



print(max(dp[n-1][0], dp[n-1][1], dp[n-1][2]))
