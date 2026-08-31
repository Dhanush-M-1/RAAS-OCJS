n,u,v=map(int,input().split())
u-=1
v-=1
ki=[[]for _ in range(n)]
for _ in range(n-1):
  a,b=map(lambda x:int(x)-1,input().split())
  ki[a].append(b)
  ki[b].append(a)
du=[0]*n
dv=[0]*n
from collections import deque
def distance(i):
  seen=[-1]*n
  seen[i]=0
  todo=deque([i])
  while todo:
    t=todo.popleft()
    l=ki[t]
    d=seen[t]
    for li in l:
      if seen[li]==-1:
        seen[li]=d+1
        todo.append(li)
  return seen
du=distance(u)
dv=distance(v)
ans=0
for i in range(n):
  if dv[i]>du[i]:
    ans=max(ans,dv[i])
print(ans-1)