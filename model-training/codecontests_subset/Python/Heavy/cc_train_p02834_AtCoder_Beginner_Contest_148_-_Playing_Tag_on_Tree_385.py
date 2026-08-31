n, u, v = map(int, input().split())
u -= 1
v -= 1
ab = [list(map(int, input().split())) for _ in range(n - 1)]

adj = [[] for _ in range(n)]
for a, b in ab:
    a -= 1
    b -= 1
    adj[a].append(b)
    adj[b].append(a)


def dfs(s):
    d = [-1] * n
    d[s] = 0
    stack = [s]
    while stack:
        frm = stack.pop()
        for to in adj[frm]:
            if d[to] == -1:
                d[to] = d[frm] + 1
                stack.append(to)

    return d


du = dfs(u)
dv = dfs(v)

ans = 0
for eu, ev in zip(du, dv):
    if eu < ev:
        ans = max(ans, ev - 1)

print(ans)
