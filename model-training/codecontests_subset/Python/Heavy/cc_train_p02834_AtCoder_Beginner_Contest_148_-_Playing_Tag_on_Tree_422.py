N,u,v=list(map(int,input().split()))
g=[[] for _ in range(N+1)]

def dist(x):
    dist=[-1]*(N+1)
    dist[x]=0
    stack=[x]
    while len(stack)>0:
        current=stack.pop()

        for s in g[current]:
            if dist[s]>-1:
                continue

            dist[s]=dist[current]+1
            stack.append(s)

    return dist

for _ in range(N-1):
    a,b=list(map(int,input().split()))

    g[a].append(b)
    g[b].append(a)

du=dist(u)
dv=dist(v)

ans=0

for i in range(1,N+1):
    if du[i]<=dv[i]:
        ans=max(ans,dv[i]-1)

print(ans)