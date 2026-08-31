n,u,v=map(int,input().split())
ki=[[] for _ in range(n)]
for _ in range(n-1):
  a,b=map(int,input().split())
  a,b=a-1,b-1
  ki[a].append(b)
  ki[b].append(a)
# 次数
dn=[len(ki[i]) for i in range(n)]
inf=float('inf')
dt=[inf]*n
da=[inf]*n
u,v=u-1,v-1
from collections import deque
todo=deque([u])
dt[u]=0
while todo:
  x=todo.popleft()
  for nx in ki[x]:
    if dt[nx]>dt[x]+1:
      dt[nx]=dt[x]+1
      todo.append(nx)
todo=deque([v])
da[v]=0
while todo:
  x=todo.popleft()
  for nx in ki[x]:
    if da[nx]>da[x]+1:
      da[nx]=da[x]+1
      todo.append(nx)
ans=0
for i in range(n):
  if dn[i]>1 and dt[i]<=da[i]:ans=max(ans,da[i])
print(ans)
exit()
print(dn)
print(dt)
print(da)