from collections import deque
N, u, v = map(int, input().split())
u -= 1
v -= 1
graph = [[] for _ in range(N)]
for _ in range(N-1):
  a, b = map(lambda x:int(x)-1, input().split())
  graph[a] += [b]
  graph[b] += [a]

def bfs(s):
  dist = [-1]*N
  q = deque([s])
  dist[s] = 0

  while q:
    u = q.popleft()
    for v in graph[u]:
      if dist[v] == -1:
        dist[v] = dist[u] + 1
        q.append(v)

  return dist

d1 = bfs(u)
d2 = bfs(v)
ans = 0
for i in range(N):
  if d1[i] < d2[i]:
    ans = max(ans, d2[i]-1)

print(ans)

