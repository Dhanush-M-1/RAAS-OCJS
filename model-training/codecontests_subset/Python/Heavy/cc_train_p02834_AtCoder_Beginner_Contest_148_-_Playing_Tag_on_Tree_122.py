import sys

sr = lambda: sys.stdin.readline().rstrip()
ir = lambda: int(sr())
lr = lambda: list(map(int, sr().split()))

N, U, V = lr()
graph = [[] for _ in range(N+1)] # 1-indexed
for _ in range(N-1):
    a, b = lr()
    graph[a].append(b)
    graph[b].append(a)

def dfs(start): # 木グラフの時
    dist = [-1] * (N+1)
    dist[start] = 0
    stack = [start]
    while stack:
        s = stack.pop()
        for x in graph[s]:
            if dist[x] != -1:
                continue
            dist[x] = dist[s] + 1
            stack.append(x)
    return dist

dist_U = dfs(U); dist_V = dfs(V)
answer = 0
for u, v in zip(dist_U[1:], dist_V[1:]):
    if v > u:
        x = v - 1
        if x > answer:
            answer = x

print(answer)
