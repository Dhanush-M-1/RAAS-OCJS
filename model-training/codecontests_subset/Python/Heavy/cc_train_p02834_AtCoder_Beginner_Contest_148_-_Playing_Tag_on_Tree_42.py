from collections import deque

N,u,v = map(int,input().split())
edges = [[] for _ in range(N+1)]
for _ in range(N-1):
    a,b = map(int,input().split())
    edges[a].append(b)
    edges[b].append(a)

distA = {}
que = deque([(u,0)])
while que:
    n,step = que.popleft()
    if n not in distA:
        distA[n] = step
        for nx in edges[n]:
            que.append((nx,step+1))

distB = {}
que = deque([(v,0)])
while que:
    n,step = que.popleft()
    if n not in distB:
        distB[n] = step
        for nx in edges[n]:
            que.append((nx,step+1))
ans = 0
for i in range(1,N+1):
    dist = distB[i]-distA[i]
    if dist > 0:
        ans = max(ans,distB[i]-1)
print(ans)
