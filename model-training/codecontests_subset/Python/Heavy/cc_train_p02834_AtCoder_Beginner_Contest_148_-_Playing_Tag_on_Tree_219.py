from collections import deque

N,u,v = map(int,input().split())
u -= 1
v -= 1
adj = [ [] for _ in range(N) ]
for _ in range(N-1):
  a,b = map(int,input().split())
  a -= 1
  b -= 1
  adj[a].append(b)
  adj[b].append(a)


def bfs(v):
  visited = [False] * N
  q = deque([v])
  span = [-1] * N

  s = 0
  while q:
    l = len(q)
    newq = deque([])

    for _ in range(l):
      node = q.popleft()
      visited[node] = True
      span[node] = s

      for nei in adj[node]:
        if not visited[nei]:
          newq.append(nei)

    q = newq
    s += 1

  return span

t = bfs(u)
a = bfs(v)

ans = 0
for i in range(N):
  if t[i] <= a[i]:
    ans = max(ans, a[i]-1)

print(ans)