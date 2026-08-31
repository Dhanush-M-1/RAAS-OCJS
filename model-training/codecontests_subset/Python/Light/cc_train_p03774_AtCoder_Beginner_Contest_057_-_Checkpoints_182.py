n,m=map(int,input().split())
a=[list(map(int,input().split())) for _ in range(n)]
b=[list(map(int,input().split())) for _ in range(m)]

for i in range(n):
  c=10**10
  e=0
  for j in range(m):
    d=abs(a[i][0]-b[j][0])+abs(a[i][1]-b[j][1])
    if d<c:
      c=d
      e=j
  print(e+1)