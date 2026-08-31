N, u, v = map(int, input().split())
AB = [list(map(int, input().split())) for i in range(N-1)]
 
#グラフ作成部
graph = [[] for i in range(N+1)]
for i,j in AB:
    graph[i].append(j)
    graph[j].append(i)
 
#深さ優先探索
def dfs(v):
    dist = [-1] * (N+1)
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
 
DU,DV = dfs(u),dfs(v)
 
answer = 0
for u,v in zip(DU[1:],DV[1:]):
    if u < v:
        x = v - 1
        if answer < x:
            answer = x
 
print(answer)