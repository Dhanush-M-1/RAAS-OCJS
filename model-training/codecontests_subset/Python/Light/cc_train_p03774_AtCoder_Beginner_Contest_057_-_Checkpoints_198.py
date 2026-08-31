N, M = map(int, input().split())
ab = [tuple(map(int, input().split())) for _ in range(N)]
cd = [tuple(map(int, input().split())) for _ in range(M)]

for a, b in ab:
  n = 10 ** 9
  m = 0
  for i, (c, d) in enumerate(cd):
    x = abs(a - c) + abs(b - d)
    if x < n:
      n = x
      m = i + 1
      
  print(m)