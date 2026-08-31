n,u,v=map(int,input().split())
u-=1
v-=1
path=[[] for _ in range(n)]
for i in range(n-1):
  a,b = [int(x)-1 for x in input().split()]
  path[a].append(b)
  path[b].append(a)
parent = [-1]*n
rank = [-1]*n
que = []
que.append(v)
rank[v]=0

while(que):
  cur = que.pop()
  for nxt in path[cur]:
    if rank[nxt]==-1:
      rank[nxt]=rank[cur]+1
      parent[nxt]=cur
      que.append(nxt)
up = (rank[u]-1)//2
upto=u
for i in range(up):
  upto = parent[upto]
depth=0
que = [upto]
while(que):
  cur = que.pop()
  if len(path[cur])==1:
    depth = max(depth,rank[cur])
  else:
    for nxt in path[cur]:
      if nxt != parent[cur]:
        que.append(nxt)
print(depth-1)
    


    
  