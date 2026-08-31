import sys
stdin = sys.stdin

ns = lambda: stdin.readline().rstrip()
ni = lambda: int(ns())
na = lambda: list(map(int, stdin.readline().split()))

n, u, v = na()
u -= 1; v -= 1
g = [[] for _ in range(n)]
for _ in range(n-1):
    a, b = na()
    a -= 1; b -= 1
    g[a].append(b)
    g[b].append(a)

def dfs(v):
    dist = [-1] * n
    stack = [v]
    dist[v] = 0
    while stack:
        v = stack.pop()
        dw = dist[v] + 1
        for w in g[v]:
            if dist[w] == -1:
                dist[w] = dw
                stack.append(w)
    return dist

dist_v = dfs(v)
dist_u = dfs(u)
ans = 0
for rv, ru in zip(dist_v, dist_u):
    if rv > ru:
        ans = max(ans, rv-1)
print(ans)

