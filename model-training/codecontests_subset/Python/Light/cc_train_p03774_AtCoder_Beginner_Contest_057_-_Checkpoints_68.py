n,m=map(int,input().split())
A=[list(map(int,input().split())) for _ in range(n)]
C=[list(map(int,input().split())) for _ in range(m)]
for i in A:
  D=[abs(i[0]-j[0])+abs(i[1]-j[1]) for j in C]
  print(D.index(min(D))+1)
