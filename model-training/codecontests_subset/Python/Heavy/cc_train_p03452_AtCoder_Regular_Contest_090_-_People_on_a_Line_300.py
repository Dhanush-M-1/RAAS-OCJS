import sys
sys.setrecursionlimit(10**6)
n,m=map(int,input().split())
g=[[] for _ in range(n)]
indeg=[0]*n
touch=[0]*n
for _ in range(m):
    l,r,d=map(int,input().split())
    l-=1
    r-=1
    touch[l]=1
    touch[r]=1
    g[l].append((r,d))
    indeg[r]+=1
if m==0:
    print('Yes')
    exit()
entered=False
for i in range(n):
    if indeg[i]==0 and touch[i]==1:
        vis=[False]*n
        entered=True
        dist=[-1]*n
        dist[i]=0
        def dfs(u):
            vis[u]=1
            for v,wt in g[u]:
                if dist[v]==-1:
                    dist[v]=dist[u]+wt
                elif dist[v]!=dist[u]+wt:
                    print('No')
                    exit()
                if vis[v]==False:
                    dfs(v)
        dfs(i)

if entered==False:
    print('No')
else:
    print('Yes')

