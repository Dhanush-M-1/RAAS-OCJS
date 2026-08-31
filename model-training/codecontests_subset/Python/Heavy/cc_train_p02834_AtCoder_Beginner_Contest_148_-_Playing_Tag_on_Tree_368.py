from collections import deque
INF = 10 ** 9 + 7

N, u, v = map(int, input().split())
X = [list(map(int, input().split())) for _ in range(N - 1)]

edges = [[] for _ in range(N)]
for x, y in X:
    edges[x - 1].append(y - 1)
    edges[y - 1].append(x - 1)
    
def bfs(s):
    d = [INF] * N
    d[s] = 0

    visited = [False] * N
    visited[s] = True
    
    q = deque()
    q.append(s)
    
    while q:
        u = q.popleft()
        for v in edges[u]:
            if visited[v]:
                continue
            
            visited[v] = True
            d[v] = d[u] + 1
            q.append(v)
            
    return d

ans = 0
for x, y in zip(bfs(u - 1), bfs(v - 1)):
    if x <= y:
        ans = max(ans, y - 1)
        
print(ans)
