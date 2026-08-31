from collections import deque
import sys
read = sys.stdin.read
readline = sys.stdin.readline

n, u, v = map(int, readline().split())
m = map(int,read().split())
data = list(zip(m,m))

graph = [[] for _ in range(n+1)]
for a,b in data:
    graph[a].append(b)
    graph[b].append(a)

def dfs(v):
    dist = [None] * (n + 1)
    dist[v] = 0
    stack = deque([v])
    while stack:
        x = stack.popleft()
        for y in graph[x]:
            if dist[y] is None:
                dist[y] = dist[x] + 1
                stack.append(y)
    return dist


res = 0
for i, j in zip(dfs(u), dfs(v)):
    if i is None:
      continue
    if i <= j:
        if j > res:
            res = j
print(res - 1)