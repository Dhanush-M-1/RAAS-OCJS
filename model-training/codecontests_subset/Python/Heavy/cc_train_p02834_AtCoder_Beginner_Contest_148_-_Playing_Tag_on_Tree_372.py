from collections import deque

N, u, v = map(int, input().split())

neighbors = [[] for i in range(N + 1)]

for _ in range(N - 1):
    A, B = map(int, input().split())
    neighbors[A].append(B)
    neighbors[B].append(A)


def BFS(neighbors, s):
    q = deque([s])
    dist = [-1] * len(neighbors)
    dist[s] = 0
    while q:
        t = q.popleft()
        d = dist[t]
        nodes = neighbors[t]
        for n in nodes:
            if dist[n] < 0:
                dist[n] = d + 1
                q.append(n)
    return dist

u_cost = BFS(neighbors, u)
v_cost = BFS(neighbors, v)

ans = 0
for i in range(1, N + 1):
    if u_cost[i] < v_cost[i]:
        ans = max(ans, v_cost[i])

print(ans - 1)