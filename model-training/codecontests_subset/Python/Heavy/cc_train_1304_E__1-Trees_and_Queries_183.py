def lca(u, v):
    if h[u] < h[v]:
        u, v = v, u
    for i in range(h[u].bit_length() - 1, -1, -1):
        if par[u][i] != -1 and h[par[u][i]] >= h[v]:
            u = par[u][i]
    if u == v:
        return u
    for i in range(h[u].bit_length() - 1, -1, -1):
        if par[u][i] != par[v][i]:
            u = par[u][i]
            v = par[v][i]
    return par[u][0]


def dist(u, v):
    lc = lca(u, v)
    return h[u] - h[lc] + h[v] - h[lc]


def cal(x, y, a, b, k):
    d = dist(a, b)
    if d <= k and (k - d) & 1 == 0:
        return True
    d = dist(a, x) + 1 + dist(y, b)
    if d <= k and (k - d) & 1 == 0:
        return True
    d = dist(a, y) + 1 + dist(x, b)
    if d <= k and (k - d) & 1 == 0:
        return True


def dfs(u, p=-1):
    stack = [(u, p)]
    while stack:
        u, p = stack.pop()
        par[u][0] = p
        if p != -1:
            h[u] = h[p] + 1
        for i in range(1, LN):
            if par[u][i - 1] != -1:
                par[u][i] = par[par[u][i - 1]][i - 1]
        for v in adj[u]:
            if v != p:
                stack.append((v, u))


n = int(input())
h = [0] * n
LN = (n - 1).bit_length()
par = [[-1] * LN for _ in range(n)]
adj = [[] for _ in range(n)]
vs = (map(int, input().split()) for _ in range(n - 1))
for u, v in vs:
    u -= 1
    v -= 1
    adj[u].append(v)
    adj[v].append(u)
dfs(0)

q = int(input())
for _ in range(q):
    x, y, a, b, k = map(int, input().split())
    print('YES' if cal(x - 1, y - 1, a - 1, b - 1, k) else 'NO')
