import sys

read = sys.stdin.read
N, u, v, *AB = map(int, read().split())

graph = [[] for _ in range(N + 1)]
for a, b in zip(*[iter(AB)] * 2):
    graph[a].append(b)
    graph[b].append(a)


def dfs(v):
    dist = [-1] * (N + 1)
    stack = [v]
    dist[v] = 0
    while stack:
        v = stack.pop()
        dw = dist[v] + 1
        for w in graph[v]:
            if dist[w] >= 0:
                continue
            dist[w] = dw
            stack.append(w)
    return dist


DU, DV = dfs(u), dfs(v)

answer = 0
for u, v in zip(DU[1:], DV[1:]):
    if u < v:
        tmp = v - 1
        if answer < tmp:
            answer = tmp

print(answer)