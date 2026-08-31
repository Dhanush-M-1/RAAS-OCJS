import sys
sys.setrecursionlimit(1000000)
n,u,v=map(int,input().split())
E=[[] for _ in range(n+1)]
for _ in range(n-1):
    a,b=map(int,input().split())
    E[a].append(b)
    E[b].append(a)
depth=[-1]*(n+1)
dis=[-1]*(n+1)
def dsf_1(p,d):
    depth[p]=d
    for c in E[p]:
        if depth[c]==-1:
            dsf_1(c,d+1)
dsf_1(v,0)
def dsf_2(p,d):
    dis[p]=d
    for c in E[p]:
        if dis[c]==-1:
            dsf_2(c,d+1)
dsf_2(u,0)
ans=0
for i in range(1,n+1):
    if len(E[i])==1 and i!=v:
        if dis[i]<depth[i]:
           ans=max(ans,depth[i]-1)
print(ans)