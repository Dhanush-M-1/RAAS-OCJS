n, u, v = map(int, input().split())
V = [ [] for _ in range(n + 1) ]
for _ in range(n - 1):
    a, b = map(int, input().split())
    V[a].append(b)
    V[b].append(a)

import collections

def bfs(x):
    X = [ -1 ] * (n + 1)
    q = collections.deque([ (x, 0) ])
    X[x] = 0
    while q:
        node, dist = q.popleft()
        for dst in V[node]:
            if X[dst] == -1:
                X[dst] = dist + 1
                q.append((dst, dist + 1))
    return X

T = bfs(u)
A = bfs(v)

ans = 0
for i in range(1, len(T)):
    if T[i] < A[i]:
        ans = max(ans, A[i] - 1)
print(ans)