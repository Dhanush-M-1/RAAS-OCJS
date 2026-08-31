from collections import deque
N,u,v=map(int,input().split())
u-=1;v-=1
G=[[] for i in range(N)]
for i in range(N-1):
    a,b=map(int,input().split())
    a-=1;b-=1
    G[a].append(b)
    G[b].append(a)
if len(G[u])==1 and G[u][0]==v:
    print(0)
    exit()
distu=[-1 for i in range(N)]
q=deque([])
q.append(u)
while(len(q)>0):
    r=q.pop()
    for p in G[r]:
        if distu[p]!=-1:
            continue
        distu[p]=distu[r]+1
        q.append(p)
distv=[-1 for i in range(N)]
q=deque([])
q.append(v)
while(len(q)>0):
    r=q.pop()
    for p in G[r]:
        if distv[p]!=-1:
            continue
        distv[p]=distv[r]+1
        q.append(p)
dist=[distv[i] if distu[i]<=distv[i] else 0 for i in range(N)]
print(max(dist))
