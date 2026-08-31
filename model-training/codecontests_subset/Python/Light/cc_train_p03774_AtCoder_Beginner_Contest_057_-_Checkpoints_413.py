N, M = map(int, input().split())
ns = [list(map(int, input().split())) for _ in range(N)]
ms = [list(map(int, input().split())) for _ in range(M)]
for n in ns:
  dmin = 2002002002
  num = -1
  for i, m in enumerate(ms):
    d = abs(n[0]-m[0])+abs(n[1]-m[1])
    if d < dmin:
      dmin = d
      num = i
  print(num+1)