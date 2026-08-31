n,m=map(int,input().split())
nl=[list(map(int,input().split())) for i in range(n)]
ml=[list(map(int,input().split())) for i in range(m)]

for j in range(n):
  best=100000000000
  for i in range(m):
    d=abs(ml[i][0]-nl[j][0]) + abs(ml[i][1]-nl[j][1])
    if best>d:
      best=d
      ans=i+1
  print(ans)