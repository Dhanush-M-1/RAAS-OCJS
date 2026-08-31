import sys
input = sys.stdin.readline

N, u, v = map(int, input().split())
u -= 1
v -= 1
F = [[] for _ in range(N)]
for _ in range(N-1):
  a, b = map(int, input().split())
  a -= 1
  b -= 1
  F[a].append(b)
  F[b].append(a)
a_dist = [-1]*N
t_dist = [-1]*N
a_dist[v] = 0
t_dist[u] = 0
def dfs(p):
  dist = [-1]*N
  stack = [p]
  dist[p] = 0
  while stack:
    q = stack.pop()
    for nq in F[q]:
      if dist[nq] == -1:
        dist[nq] = dist[q]+1
        stack.append(nq)
  return dist
a_dist = dfs(v)
t_dist = dfs(u)
ans = 0
for t, a in zip(t_dist, a_dist):
  if t < a:
    temp = a-1
    if ans < temp:
      ans = temp
    
print(ans)