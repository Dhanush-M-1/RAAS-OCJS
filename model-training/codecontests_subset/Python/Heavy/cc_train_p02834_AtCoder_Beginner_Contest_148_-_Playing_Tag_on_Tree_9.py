from collections import deque

def BFS(s):
 tree=[[] for i in range(n)]
 for i in list:
  tree[i[0]-1].append(i[1]-1)
  tree[i[1]-1].append(i[0]-1)

 dist=[-1 for i in range(n)]
 dist[s-1]=0

 que=deque()
 que.append(s-1)
 while que:
  x=que.popleft()
  for p in tree[x]:
   if dist[p]==-1:
    que.append(p)
    dist[p]=dist[x]+1
 return dist

n,u,v=map(int,input().split())
list=[list(map(int,input().split())) for i in range(n-1)]

u_dist=BFS(u)
v_dist=BFS(v)

l=0
for u_d,v_d in zip(u_dist,v_dist):
 if u_d<v_d:
  l=max(l,v_d)

print(l-1)