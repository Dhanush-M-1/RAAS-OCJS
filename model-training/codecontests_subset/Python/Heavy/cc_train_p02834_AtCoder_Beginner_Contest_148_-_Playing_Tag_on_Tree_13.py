from collections import deque
N, u, v = map(int, input().split())

G = [[] for _ in range(N + 1)]
for i in range(N - 1):
    a, b = map(int, input().split())
    G[a].append(b)
    G[b].append(a)


def bfs(s):
    dist = [-1] * (N + 1)
    dist[s] = 0
    d = deque([s])
    while len(d) > 0:
        v = d.popleft()
        for w in G[v]:
            if dist[w] < 0:
                dist[w] = dist[v] + 1
                d.append(w)
    return dist


tkhs = bfs(u)
aok = bfs(v)
ans = 0
for i in range(1, N + 1):
    if tkhs[i] < aok[i]:
        ans = max(ans, aok[i] - 1)
print(ans)
