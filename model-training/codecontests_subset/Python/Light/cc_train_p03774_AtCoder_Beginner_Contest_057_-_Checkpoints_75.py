n, m = map(int, input().split())
a = [list(map(int, input().split())) for i in range(n)]
c = [list(map(int, input().split())) for i in range(m)]
for i in range(n):
  dist = []
  for k in range(m):
    dist.append(abs(a[i][0]-c[k][0])+abs(a[i][1]-c[k][1]))
  print(dist.index(min(dist))+1)