import sys
read = sys.stdin.buffer.read
readline = sys.stdin.buffer.readline
readlines = sys.stdin.buffer.readlines

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
    stack = [v]
    while stack:
        x = stack.pop()
        for y in graph[x]:
            if dist[y] is None:
                dist[y] = dist[x] + 1
                stack.append(y)
    return dist
res = 0
du, dv = dfs(u), dfs(v)
for i in range(1, n+1):
    dvi = dv[i]
    if du[i] <= dvi:
        if dvi > res:
            res = dvi
print(res - 1)