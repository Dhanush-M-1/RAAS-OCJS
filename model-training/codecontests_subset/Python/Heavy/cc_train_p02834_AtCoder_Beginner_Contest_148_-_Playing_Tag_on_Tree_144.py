from collections import deque
n,u,v=map(int,input().split())
G=[[] for i in range(n)]
dist_u=[-1]*n
dist_v=[-1]*n
for i in range(n-1):
    a,b=map(int,input().split())
    G[a-1].append(b-1)
    G[b-1].append(a-1)

u-=1
v-=1

dist_u[u]=0
q=deque([u])

while q:
    cur=q.popleft()
    for nx in G[cur]:
        if dist_u[nx]==-1:
            q.append(nx)
            dist_u[nx]=dist_u[cur]+1

dist_v[v]=0
q=deque([v])

while q:
    cur=q.popleft()
    for nx in G[cur]:
        if dist_v[nx]==-1:
            q.append(nx)
            dist_v[nx]=dist_v[cur]+1
ans=0
for i in range(n):
    if dist_u[i]<dist_v[i] and dist_v[i]>=ans:
        ans=dist_v[i]
print(ans-1)


