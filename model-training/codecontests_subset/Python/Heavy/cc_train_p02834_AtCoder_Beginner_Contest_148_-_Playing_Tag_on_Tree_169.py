n,u,v = map(int,input().split())
lis = [list(map(int,input().split())) for i in range(n-1)]

graph = [[] for _ in range(n+1)]

for a,b in lis:
    graph[a].append(b)
    graph[b].append(a)

def dfs(v):
    dist = [-1] * (n+1)
    stack = [v]
    dist[v] = 0
    while stack:
        v = stack.pop()
        dw = dist[v] + 1
        for w in graph[v]:
            if dist[w] >= 0:
                continue
            dist[w] = dw
            stack.append(w)
    return dist

takahashi = dfs(u)
aoki = dfs(v)

ans = 0

for i in range(1,n+1):
    if takahashi[i] < aoki[i]:
        ans = max(ans,aoki[i]-1)

print(ans)