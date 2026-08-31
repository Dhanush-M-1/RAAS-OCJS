import sys
from collections import deque as dq
input = sys.stdin.readline
H, W, K = map(int, input().split())
a = []
s = 0
for _ in range(H): a += list(input())[: -1]
for i in range(H * W):
  if a[i] == "S":
    s = i
    break
Q = dq([s])
d = [-1, 0, 1, 0]
dp = [float("inf")] * (H * W)
dp[s] = 0
while len(Q):
  p = Q.popleft()
  for k in range(4):
    q = p + d[k] + d[-1 - k] * W
    if q in range(H * W):
      if a[q] == "#": continue
      if dp[p] + 1 < dp[q]:
        dp[q] = dp[p] + 1
        Q.append(q)
res = float("inf")
for i in range(H * W):
  if dp[i] > K: continue
  n = i // W
  s = H - (i // W) - 1
  e = W - (i % W) - 1
  w = i % W
  res = min(res, -(-min(n, s, e, w) // K))
print(res + 1)