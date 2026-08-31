s = input()
n = len(s)
k = int(input())
dp = [[[0 for _ in range(2)] for _ in range(k + 1)] for _ in range(n + 1)]
dp[0][0][0] = 1
for a in range(n):
  for b in range(k + 1):
    for c in range(2):
      nd = int(s[a])
      for d in range(10):
        na, nb, nc = a + 1, b, c
        if d != 0:
          nb += 1
        if nb > k:
          break
        if 0 == nc:
          if d > nd:
            break
          if d < nd:
            nc += 1
        dp[na][nb][nc] += dp[a][b][c]
print(sum(dp[-1][-1]))
          