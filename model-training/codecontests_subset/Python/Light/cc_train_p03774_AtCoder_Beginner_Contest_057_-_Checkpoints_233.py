N, M = map(int, input().split())

AB = [list(map(int, input().split())) for _ in range(N)]
CD = [list(map(int, input().split())) for _ in range(M)]

for i in range(N):
  check = []
  for j in range(M):
    check.append(abs(AB[i][0] - CD[j][0]) + abs(AB[i][1] - CD[j][1]))
  print(check.index(min(check)) + 1)