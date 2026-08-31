from collections import deque


def solve(adj):
    n = len(adj)
    color = [None] * n
    for u in range(n):
        if color[u] is None:
            color[u] = 0
            q = deque()
            q.append(u)
            while q:
                x = q.popleft()
                for y in adj[x]:
                    if color[y] is None:
                        color[y] = color[x] ^ 1
                        q.append(y)
                    else:
                        if color[y] == color[x]:
                            return None
    return [[i for i in range(n) if color[i] == c] for c in range(2)]


n, m = map(int, input().split())
adj = [[] for i in range(n)]
for i in range(m):
    u, v = map(int, input().split())
    adj[u - 1].append(v - 1)
    adj[v - 1].append(u - 1)
res = solve(adj)
if res is None:
    print(-1)
else:
    for l in res:
        print(len(l))
        print(*[e + 1 for e in l])
