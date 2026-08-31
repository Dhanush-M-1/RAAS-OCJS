N, u, v = map(int, input().split())
AB = [list(map(int, input().split())) for i in range(N - 1)]

u -= 1
v -= 1
G = [set() for _ in range(N)]
for a, b in AB:
    G[a - 1].add(b - 1)
    G[b - 1].add(a - 1)


du = [-1] * N
du[u] = 0
q = set([u])
while q:
    i = q.pop()
    for j in G[i]:
        if du[j] == -1:
            du[j] = du[i] + 1
            q.add(j)

dv = [-1] * N
dv[v] = 0
q = set([v])
while q:
    i = q.pop()
    for j in G[i]:
        if dv[j] == -1:
            dv[j] = dv[i] + 1
            q.add(j)

ans = 0
for i in range(N):
    if du[i] < dv[i]:
        ans = max(ans, dv[i])
ans -= 1

print(ans)
