import sys
read = sys.stdin.buffer.read
readline = sys.stdin.buffer.readline
readlines = sys.stdin.buffer.readlines

N,U,V = map(int,readline().split())
m = map(int,read().split())
AB = zip(m,m)

graph = [[] for _ in range(N+1)]
for a,b in AB:
    graph[a].append(b)
    graph[b].append(a)

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

DU,DV = dfs(U),dfs(V)

answer = 0
for u,v in zip(DU[1:],DV[1:]):
    if u < v:
        x = v - 1
        if answer < x:
            answer = x

print(answer)