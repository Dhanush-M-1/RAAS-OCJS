from collections import deque

N,u,v = map(int, input().split())
edge = [[] for _ in range(N)]
for _ in range(N - 1):
    a,b = map(int, input().split())
    edge[a-1].append(b-1)
    edge[b-1].append(a-1)

u -= 1; v -= 1

def bfs(s):
    dist = [-1] * N
    prev = [-1] * N
    que = deque([s])
    dist[s] = 0
    while que:
        v = que.popleft()
        for w in edge[v]:
            if dist[w] < 0:
                dist[w] = dist[v] + 1
                prev[w] = v
                que.append(w)
    return dist, prev

takahashi, _ = bfs(u)
aoki, prev = bfs(v)

node = 0
dist = -1
for i,(t,a) in enumerate(zip(takahashi, aoki)):
    if t < a and a > dist:
        dist = a
        node = i

print(aoki[prev[node]])