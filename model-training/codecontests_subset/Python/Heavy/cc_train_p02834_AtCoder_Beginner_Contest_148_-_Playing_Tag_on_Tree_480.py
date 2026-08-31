
from collections import deque

N, u, v = map(int, input().split())
X = [list(map(int, input().split())) for _ in range(N - 1)]

graph = [[] for _ in range(N + 1)]
for a, b in X:
    graph[a].append(b)
    graph[b].append(a)


def bfs(s):
    INF = 10 ** 9 + 7
    d = [INF] * (N + 1)
    d[s] = 0
    q = deque([s])
    while q:
        u = q.popleft()
        for v in graph[u]:
            if d[v] > d[u] + 1:
                d[v] = d[u] + 1
                q.append(v)

    return d


to = bfs(u)
ot = bfs(v)

ans = 0
for i, (a, b) in enumerate(zip(to, ot)):
    if a < b:
        ans = max(ans, b)
print(ans - 1)
