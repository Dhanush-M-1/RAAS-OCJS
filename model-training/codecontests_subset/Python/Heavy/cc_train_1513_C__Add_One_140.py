import sys
input = sys.stdin.readline

M = 10 ** 9 + 7

dp = [[0, 0] for i in range(200001)]
for i in range(200001):
  if i < 10:
    dp[i][0] = 1
    dp[i][1] = 1
    if i == 9:
      dp[i][1] = dp[1][1] + dp[1][0]
  else:
    dp[i][0] = (dp[i - 10][1] + dp[i - 10][0]) % M
    dp[i][1] = (dp[i - 9][1] + dp[i - 9][0]) % M

def solve(n, m):
  s = list(str(n))
  z = 0
  for i in range(len(s)):
    x = int(s[i])
    if x + m < 10:
      z += 1
    else:
      z += dp[m - (10 - x)][1] + dp[m - (10 - x)][0]
  return str(z % M)

t = int(input())
o = []
while t > 0:
  n, m = map(int, input().split())
  o.append(solve(n, m))
  t -= 1
print('\n'.join(o))
