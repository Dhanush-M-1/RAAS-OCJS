from collections import deque

def solveOne():
    nVertices, nEdges, v1, v2 = map(int, input().split())
    v1 -= 1
    v2 -= 1
    g = [[] for _ in range(nVertices)]
    for _ in range(nEdges):
        u, v = map(lambda x: int(x) - 1, input().split())
        g[u].append(v)
        g[v].append(u)

    def bfs(start, restricted):
        visited = {start}
        q = deque([start])
        while q:
            v = q.pop()
            for to in g[v]:
                if to != restricted and to not in visited:
                    visited.add(to)
                    q.appendleft(to)
        return visited - {start}

    set1 = bfs(v1, v2)
    set2 = bfs(v2, v1)
    return len(set1 - set2) * len(set2 - set1)

for _ in range(int(input())):
    print(solveOne())