N,M = list(map(int,input().split()))
s = [list(map(int,input().split())) for i in range(N)]
c = [list(map(int,input().split())) for i in range(M)]

for i in range(N):
  d = []
  for j in range(M):
    d.append(abs(s[i][0]-c[j][0])+abs(s[i][1]-c[j][1]))
  print(d.index(min(d))+1)