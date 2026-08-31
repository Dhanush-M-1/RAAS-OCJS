import sys

sr = lambda: sys.stdin.readline().rstrip()
ir = lambda: int(sr())
lr = lambda: list(map(int, sr().split()))

N, U, V = lr()
edges = [[] for _ in range(N+1)] # 1-indexed
for _ in range(N-1):
    a, b = lr()
    edges[a].append(b)
    edges[b].append(a)

def dfs(v):
    dist = [-1] * (N+1)
    dist[v] = 0
    stack = [v]
    while stack:
        s = stack.pop()
        for x in edges[s]:
            if dist[x] != -1:
                continue
            dist[x] = dist[s] + 1
            stack.append(x)
    return dist

DU, DV = dfs(U), dfs(V)
answer = 0
for u, v in zip(DU[1:], DV[1:]):
    if v > u:
        x = v - 1
        if x > answer:
            answer = x

print(answer)
