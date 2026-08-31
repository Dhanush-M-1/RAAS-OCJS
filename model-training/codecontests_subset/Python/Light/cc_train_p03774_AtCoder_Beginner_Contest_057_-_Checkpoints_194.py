n,m = map(int,input().split())
std = []
for i in range(n):
  std.append(list(map(int,input().split())))
chk = []
for j in range(m):
  chk.append(list(map(int,input().split())))
for i in range(n):
  can = []
  for j in range(m):
    can.append([abs(std[i][0]-chk[j][0])+abs(std[i][1]-chk[j][1]),j+1])
  print(min(can)[1])