n,m = map(int, input().split())
ab = [list(map(int, input().split())) for _ in range(n)]
cd = [list(map(int, input().split())) for _ in range(m)]

for i in range(n):
  s = 0
  t = float('inf')
  for j in range(m):
    p = abs(ab[i][0] - cd[j][0]) + abs(ab[i][1] - cd[j][1])
    if p < t:
      s = j+1
      t = p
  print(s) 