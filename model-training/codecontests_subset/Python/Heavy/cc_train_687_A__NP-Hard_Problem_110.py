from sys import setrecursionlimit
setrecursionlimit(100000)
from collections import deque

UNDEF = -1

nVertices, nEdges = map(int, input().split())
g = [[] for _ in range(nVertices)]
edges = []
for _ in range(nEdges):
    u, v = map(lambda x: int(x) - 1, input().split())
    g[u].append(v)
    g[v].append(u)
    edges.append((u, v))

def dfs(v, m):
    mark[v] = m
    for to in g[v]:
        if mark[to] == UNDEF:
            dfs(to, m ^ 1)

def bfs(v):
    q = deque([(v, 0)])
    while q:
        v, m = q.pop()
        mark[v] = m
        for to in g[v]:
            if mark[to] == UNDEF:
                q.appendleft((to, m ^ 1))

mark = [UNDEF] * nVertices
for v in range(nVertices):
    if mark[v] == UNDEF:
        bfs(v)
cnt1 = cnt2 = 0
for u, v in edges:
    cnt1 += mark[u] == 0 or mark[v] == 0
    cnt2 += mark[u] == 1 or mark[v] == 1
if cnt1 != nEdges or cnt2 != nEdges:
    print(-1)
else:
    ret = []
    ret.append('%d\n' % mark.count(0))
    vertices = []
    for v in range(nVertices):
        if mark[v] == 0:
            vertices.append(v + 1)
    ret.append('%s\n' % ' '.join(map(str, vertices)))
    ret.append('%d\n' % mark.count(1))
    vertices = []
    for v in range(nVertices):
        if mark[v] == 1:
            vertices.append(v + 1)
    ret.append('%s\n' % ' '.join(map(str, vertices)))
    print(''.join(ret))