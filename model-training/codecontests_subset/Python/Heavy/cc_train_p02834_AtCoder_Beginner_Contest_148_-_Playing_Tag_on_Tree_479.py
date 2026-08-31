from collections import*
n,u,v=map(int,input().split())
e=[[]for _ in range(n+1)]
INF=10**18
d=[INF]*(n+1)
for _ in range(n-1):
  a,b=map(int,input().split())
  e[a]+=[b]
  e[b]+=[a]
q=deque([(v,0)])
while q:
  now,c=q.popleft()
  d[now]=c
  for to in e[now]:
    if d[to]!=INF:continue
    q.append((to,c+1))
q=[(u,0)]
ans=0
vis=[1]*(n+1)
while q:
  now,c=q.pop()
  vis[now]=0
  f=1
  for to in e[now]:
    if vis[to]:
      f=0
      if d[to]>c+1:q+=[(to,c+1)]
      if d[to]==c+1:ans=max(c+1,ans)
      else:ans=max(c,ans)
  if len(e[now])==1:ans=max(d[to],ans)
print(ans)