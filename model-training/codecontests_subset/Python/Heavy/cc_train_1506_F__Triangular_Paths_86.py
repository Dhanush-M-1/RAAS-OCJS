import sys
input = sys.stdin.readline
for _ in range(int(input())):
  n = int(input())
  r = list(map(int, input().split()))
  c = list(map(int, input().split()))
  ps = [(r[i], c[i]) for i in range(n)]
  ps.sort()
  y = 1
  x = 1
  res = 0

  for i in range(n):
    u, v = ps[i]
    #print(y, x, res)
    if y == u and x == v: continue
    if (y + x) % 2 == 0:
      if y + 1 == u and x + 1 == v:
        res += 1
        y, x = u, v
        continue
      y += 1
    uv = u - v
    yx = y - x
    if uv >= yx: res += -((yx - uv) // 2)
    else: res += abs(v - x)
    y, x = u, v
  print(res)