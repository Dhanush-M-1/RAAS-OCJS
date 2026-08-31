n, m = map(int,input().split())

ab = [list(map(int,input().split())) for i in range(n)]
cd = [list(map(int,input().split())) for i in range(m)]

for i in range(n):
  x=[]
  for j in range(m):
    x.append(abs(ab[i][0]-cd[j][0])+abs(ab[i][1]-cd[j][1]))
  print(x.index(min(x))+1)