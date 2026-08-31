I = [int(_) for _ in open(0).read().split()]
N, U, V = I[:3]
A, B = I[3::2], I[4::2]
G = [set() for _ in range(N + 1)]
for a, b in zip(A, B):
    G[a].add(b)
    G[b].add(a)


def dfs(x):
    dist = [None] * (N + 1)
    dist[x] = 0
    stack = set([x])
    while stack:
        x = stack.pop()
        for xn in G[x]:
            if dist[xn] is None:
                dist[xn] = dist[x] + 1
                stack.add(xn)
    return dist


distt = dfs(U)
dista = dfs(V)
ans = 0
for t, a in zip(distt[1:], dista[1:]):
    if t < a:
        ans = max(ans, a - 1)
print(ans)
