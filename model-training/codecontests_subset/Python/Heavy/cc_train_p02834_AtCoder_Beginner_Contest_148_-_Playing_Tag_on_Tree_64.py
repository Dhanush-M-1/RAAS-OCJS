from collections import deque

N, U, V = map(int, input().split())
X = [list(map(int, input().split())) for _ in range(N - 1)]

tree = [[] for _ in range(N + 1)]
for a, b in X:
    tree[a].append(b)
    tree[b].append(a)

def find_dist(s):
    dist = [-1] * (N + 1)
    dist[s] = 0
    q = deque()
    q.append(s)
    while q:
        u = q.popleft()
        for v in tree[u]:
            if dist[v] >= 0:
                continue
                
            dist[v] = dist[u] + 1
            q.append(v)
            
    return dist


dist_u = find_dist(U)
dist_v = find_dist(V)

ans = 0
for i in range(1, N + 1):
    if dist_u[i] <= dist_v[i]:
        ans = max(ans, dist_v[i] - 1)
        
print(ans)

