N,M = map(int, input().split())
S = [list(map(int, input().split())) for _ in range(N)]
P = [list(map(int, input().split())) for _ in range(M)]

for i in range(N):
  d = []
  for j in range(M):
    d_x = abs(S[i][0] - P[j][0])
    d_y = abs(S[i][1] - P[j][1])
    d.append(d_x + d_y)
  print(d.index(min(d)) + 1)
  