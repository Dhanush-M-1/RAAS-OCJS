n,m = map(int,input().split())
a = [list(map(int,input().split())) for _ in range(n)]
b = [list(map(int,input().split())) for _ in range(m)]
for x in a:
  ans,dist = -1,1000000000
  for i in range(m):
    d = abs(x[0]-b[i][0])+abs(x[1]-b[i][1])
    if d < dist:
      ans, dist = i+1,d
  print(ans)