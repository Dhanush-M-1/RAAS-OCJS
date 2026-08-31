from collections import deque

n,u,v=map(int,input().split())
u-=1
v-=1

a=[[] for i in range(n)]


for i in range(n-1):
  s,t=map(int,input().split())
  a[s-1].append(t-1)
  a[t-1].append(s-1)


def bfs(x):
  dist=[-1]*n
  dist[x]=0
  Q=deque()
  Q.append((x))

  while Q:
    q=Q.popleft()
    for i in a[q]:
      if dist[i]==-1:
        dist[i]=dist[q]+1
        Q.append((i))

  return dist

taka=bfs(u)
aoki=bfs(v)

ans=0
for i in range(n):
  if taka[i]<aoki[i]:
    ans=max(ans,aoki[i]-1)


print(ans)