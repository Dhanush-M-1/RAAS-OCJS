N, U, V = map(int, input().split())
AB = [list(map(int, input().split())) for _ in range(N - 1)]

graph = [[] for _ in range(N + 1)]
for A, B in AB:
  graph[A].append(B)
  graph[B].append(A)

INF = 10 ** 15
dist_U = [INF] * (N + 1)
dist_V = [INF] * (N + 1)

def dfs(start, dist):
  stack = [start]
  dist[start] = 0
  
  while stack:
    s = stack.pop()
    for g in graph[s]:
      if dist[g] > dist[s] + 1:
        dist[g] = dist[s] + 1
        stack.append(g)

dfs(U, dist_U)
dfs(V, dist_V)
#print("dist_U", dist_U)
#print("dist_V", dist_V)

answer = []
for i in range(1, N + 1):
  if dist_U[i] < dist_V[i]:
    answer.append(dist_V[i] - 1)
print(max(answer))