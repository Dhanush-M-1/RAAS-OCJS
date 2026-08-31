def d(x, y):
  return abs(x[0] - y[0]) + abs(x[1] - y[1])
n, m = map(int, input().split())
x = [tuple(map(int, input().split())) for i in range(n)]
y = [tuple(map(int, input().split())) for i in range(m)]
for i in range(n):
  p = 0
  for j in range(1, m):
    if d(x[i], y[j]) < d(x[i], y[p]):
      p = j
  print(p + 1)
