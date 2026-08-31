from collections import deque

n,u,v = map(int,input().split())
u -= 1
v -= 1
G = [[] for _ in range(n)]
for _ in range(n-1):
    a,b = map(int,input().split())
    a -= 1
    b -= 1
    G[a].append(b)
    G[b].append(a)

def bfs(x):
    dist = [-1]*n
    dist[x] = 0
    que = deque([x])
    while que:
        now = que.pop()
        for nex in G[now]:
            if dist[nex] != -1:continue
            dist[nex] = dist[now] + 1
            que.appendleft(nex)
    return dist

dist_u = bfs(u)
dist_v = bfs(v)

ans = 0
for i in range(n):
    if dist_u[i] < dist_v[i]:
        ans = max(ans,dist_v[i]-1)

print(ans)