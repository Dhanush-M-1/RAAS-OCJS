from collections import deque

n,u,v=map(int,input().split())

tree=[[] for i in range(n)]
for i in range(n-1):
 i,j=map(int,input().split())
 tree[i-1].append(j-1)
 tree[j-1].append(i-1)

def BFS(s):
 dist=[-1 for i in range(n)]
 dist[s]=0

 que=deque()
 que.append(s)

 while que:
  x=que.popleft()
  for p in tree[x]:
   if dist[p]==-1:
    que.append(p)
    dist[p]=dist[x]+1

 return dist

u_dist=BFS(u-1)
v_dist=BFS(v-1)

l=0
for u_d,v_d in zip(u_dist,v_dist):
 if u_d<v_d:
  l=max(l,v_d)

print(l-1)