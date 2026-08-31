N, M = map(int,input().split())
AB = [list(map(int,input().split())) for _ in range(N)]
CD = [list(map(int,input().split())) for _ in range(M)]

result = []
for a, b in AB:
  tmp = []
  for c, d in CD:
    tmp.append(abs(a-c) + abs(b-d))
  result.append(tmp.index(min(tmp))+1)
for r in result:
  print(r)