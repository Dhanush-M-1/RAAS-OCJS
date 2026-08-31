n,m = map(int, input().split())
a = set([int(input()) for _ in range(m)])

dp = [1,1]
if 1 in a: dp[1] = 0
  
for i in range(2,n+1):
  if i in a: dp.append(0)
  else: dp.append(dp[i-1] + dp[i-2])

print(dp[n]%1000000007)