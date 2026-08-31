from collections import defaultdict as dd,deque as dq
n,m=map(int,input().split())
def bfs(a,vis,le,ri,g,lol):
    q=dq([a])
    while q:
        a=q.pop()
        vis[a]=1
        for j in d[a]:
            if(vis[j]==0):
                if(g[a]==1):
                    g[j]=0
                else:
                    g[j]=1
                q.appendleft(j)
            else:
                if(g[a]==g[j]):
                    #print(a,j,g[a])
                    lol[0]=1
                    return
d=dd(list)
for i in range(m):
    u,v=map(int,input().split())
    d[u].append(v)
    d[v].append(u)
vis=[0]*(n+1)
le=[]
ri=[]
g=[0]*(n+1)
lol=[0]
for i in range(1,n+1):
    if vis[i]==0:
        bfs(i,vis,le,ri,g,lol)
#print(g)
if(lol[0]):
    print(-1)
else:
    for i in range(1,n+1):
        if(g[i]):
            le.append(i)
        else:
            ri.append(i)
    print(len(le))
    print(*le)
    print(len(ri))
    print(*ri)