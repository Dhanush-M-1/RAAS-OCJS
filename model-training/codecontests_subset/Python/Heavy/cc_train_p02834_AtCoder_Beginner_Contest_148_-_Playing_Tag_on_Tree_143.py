import sys

sys.setrecursionlimit(10**6)


def get_distance(v):              
    distance = [0] * n
    visited = [0] * n
    visited[v] = 1
    dfs(v, 0, distance, visited)
    return distance


def dfs(v, d, distance, visited):
    distance[v] = d
    for u in adj[v]:
        if not visited[u]:
            visited[u] = 1
            dfs(u, d + 1, distance, visited)


n, u, v = map(int, input().split())

adj = [[] for _ in range(n)]
for _ in range(n - 1):
    a, b = (int(i) - 1 for i in input().split()) 
    adj[a].append(b)
    adj[b].append(a)

u_distance = get_distance(u - 1)
v_distance = get_distance(v - 1)

ans = 0
for u, v in zip(u_distance, v_distance):
    if u < v and v - 1 > ans:
        ans = v - 1

print(ans)