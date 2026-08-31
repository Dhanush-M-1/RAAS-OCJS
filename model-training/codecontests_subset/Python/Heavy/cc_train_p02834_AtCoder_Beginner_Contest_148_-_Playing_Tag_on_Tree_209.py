from collections import deque
n,u,v = map(int,input().split())
Edge = [[] for i in range(n)]

for i in range(n-1):
    a,b = map(int,input().split())
    Edge[a-1].append(b-1)
    Edge[b-1].append(a-1)

def bfs(s):
    dist = [-1]*n
    que = deque([s-1])
    dist[s-1] = 0
    while que:
        v = que.popleft()
        d = dist[v]
        for w in Edge[v]:
            if dist[w] > -1:
                continue

            dist[w] = d+1
            que.append(w)
    return dist

U,V = bfs(u),bfs(v)

ans = 0

for i in range(n):
    if U[i] < V[i]:
        ans = max(ans,V[i]-1)

print(ans)