import sys

n, u, v = map(int, sys.stdin.readline().split())
graph = [[] for _ in range(n+1)]
for i in range(n-1):
    a, b = map(int, sys.stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a)

def dfs(v):
    dist = [-1] * (n+1)
    dist[v] = 0
    stack = [v]
    while stack:
        now = stack.pop()
        dw = dist[now] + 1
        for ne in graph[now]:
            if dist[ne] >= 0:
                continue
            dist[ne] = dw
            stack.append(ne)
    return dist

Takahashi = dfs(u)
Aoki = dfs(v)

ans = 0
for t, a in zip(Takahashi[1:], Aoki[1:]):
    if t < a:
        ans = max(ans, a - 1)

print(ans)
