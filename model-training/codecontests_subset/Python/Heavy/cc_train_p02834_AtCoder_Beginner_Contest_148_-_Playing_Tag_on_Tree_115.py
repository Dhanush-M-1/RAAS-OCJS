from collections import deque
N,u,v = map(int,input().split())
edge = [[] for i in range(N)]
for i in range(N-1):
  a,b = map(int, input().split())
  edge[a-1].append(b-1)
  edge[b-1].append(a-1)

def bfs(s):
  dist = [-1]*N
  que = deque([s-1])
  dist[s-1] = 0
  while que:
    v = que.popleft()
    d = dist[v]
    for w in edge[v]:
      if dist[w]>-1: continue
      dist[w] = d+1
      que.append(w)
  return dist

ud,vd = bfs(u),bfs(v)
ans = 0
for ud_i,vd_i in zip(ud,vd): ans = max(ans, vd_i-1) if ud_i<vd_i else ans
print(ans)
