N, u, v = map(int, input().split())
ABs = [tuple(map(int, input().split())) for _ in range(N - 1)]

def BFS(K, edges, N):
    roots = [[] for _ in range(N)]
    for a, b in edges:
        roots[a-1] += [(b-1)]
        roots[b-1] += [(a-1)]
    dist = [-1]*N
    stack = []
    stack.append(K)
    dist[K] = 0
    while stack:
        label = stack.pop(-1)
        for i in roots[label]:
            if dist[i] == -1:
                dist[i] = dist[label] + 1
                stack += [i]
    return dist

U = BFS(u - 1, ABs, N)
V = BFS(v - 1, ABs, N)

max_ = 0
for a, b in zip(U, V):
    if a < b:
        max_ = max(max_, b - 1)

print(max_)