import sys
from array import array  # noqa: F401


def input():
    return sys.stdin.buffer.readline().decode('utf-8')


n = int(input())
adj = [[] for _ in range(n)]
deg = [0] * n

for u, v in (map(int, input().split()) for _ in range(n - 1)):
    adj[u - 1].append(v - 1)
    adj[v - 1].append(u - 1)
    deg[u - 1] += 1
    deg[v - 1] += 1

groups = []
remove_edge = []
visited = [0] * n
visited2 = [0] * n


def dfs(stack: list):
    while stack:
        v = stack.pop()
        deg[v] = 0
        visited2[v] = 1
        for dest in adj[v]:
            if not deg[dest]:
                continue
            deg[dest] -= 1
            if deg[dest] == 1:
                stack.append(dest)


for i in range(n):
    if visited[i]:
        continue
    visited[i] = 1
    groups.append(i + 1)
    vs = [i]
    stack = [i]
    nstack = []

    while stack:
        v = stack.pop()
        if deg[v] <= 1:
            nstack.append(v)
        for dest in adj[v]:
            if not visited[dest]:
                visited[dest] = 1
                stack.append(dest)
                vs.append(dest)

    dfs(nstack)

    vs = [v for v in vs if not visited2[v]]

    while vs:
        u, v = vs[-1], [x for x in adj[vs[-1]] if not visited2[x]][0]
        adj[u].remove(v)
        adj[v].remove(u)
        deg[u] -= 1
        deg[v] -= 1
        remove_edge.append(f'{u+1} {v+1} ')
        if deg[u] == 1:
            nstack.append(u)
        if deg[v] == 1:
            nstack.append(v)

        dfs(nstack)
        vs = [v for v in vs if not visited2[v]]


ans = []
for i, s in enumerate(remove_edge):
    ans.append(s + f'{groups[i]} {groups[i+1]}')

sys.stdout.buffer.write((str(len(ans)) + '\n' + '\n'.join(ans)).encode('utf-8'))
