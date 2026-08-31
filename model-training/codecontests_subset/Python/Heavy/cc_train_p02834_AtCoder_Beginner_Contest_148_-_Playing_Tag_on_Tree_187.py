from collections import deque

INF = -1

n, t, a = map(int, input().split())
t -= 1
a -= 1
g = [[] for _ in range(n)]
for _ in range(n - 1):
    u, v = map(lambda x: int(x) - 1, input().split())
    g[u].append(v)
    g[v].append(u)

def bfs(start):
    dist = [INF] * n
    dist[start] = 0
    q = deque([start])
    while q:
        cur = q.pop()
        for to in g[cur]:
            if dist[to] == INF:
                dist[to] = 1 + dist[cur]
                q.appendleft(to)
    return dist

distT = bfs(t)
distA = bfs(a)
ret = 0
for v in range(n):
    if distT[v] < distA[v]:
        ret = max(ret, distA[v] - 1)
print(ret)