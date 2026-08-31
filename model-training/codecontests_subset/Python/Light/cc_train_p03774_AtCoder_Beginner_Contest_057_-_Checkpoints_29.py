n,m=map(int,input().split())
p=[list(map(int,input().split())) for i in range(n)]
q=[list(map(int,input().split())) for i in range(m)]
for x in range(n):
  c=[]
  for y in range(m):
    c.append(abs(p[x][0]-q[y][0])+abs(p[x][1]-q[y][1]))
  print(c.index(min(c))+1)