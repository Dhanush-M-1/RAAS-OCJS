from collections import deque
n,u,v=map(int,input().split())
graph=[[] for i in range(n)]
for i in range(n-1):
  a,b=map(int,input().split())
  a-=1;b-=1
  graph[a].append(b)
  graph[b].append(a)
Q=deque([v-1])
Vert=[[0,0] for i in range(n)]
visited=[False]*n
visited[v-1]=True
while Q:
  V=Q.popleft()
  visited[V]=True
  for i in graph[V]:
    if visited[i]:continue
    if i == V:continue
    Vert[i][0]=Vert[V][0]+1
    Q.append(i)
visited=[False]*n
visited[u-1]=True
Q.append(u-1)
while Q:
  V=Q.popleft()
  visited[V]=True
  for i in graph[V]:
    if visited[i]:continue
    if i == V:continue
    Vert[i][1]=Vert[V][1]+1
    Q.append(i)
ans=0
for i in Vert:
  if i[0]>i[1]:
    if i[0]>ans:
      ans=i[0]
print(ans-1)