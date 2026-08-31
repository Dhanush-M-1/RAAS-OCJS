n,m=map(int,input().split())
std = [list(map(int,input().split())) for i in range(n)]
chk = [list(map(int,input().split())) for i in range(m)]
for s in std:
  ans=[]
  for i in range(m):
    ans.append([abs(s[0]-chk[i][0])+abs(s[1]-chk[i][1]),i+1])
    ans.sort()
  print(ans[0][1])