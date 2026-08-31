n, m = map(int, input().split())
x, y = [], []
res = [-1] * (n+1)
adj = [[] for i in range(n+1)]

for _ in range(m):
    u, v = map(int, input().split())
    adj[u].append(v)
    adj[v].append(u)
    x.append(u)
    y.append(v)

def dfs(u, p):
    stk = [(u, p)] 
    while stk:
        u, p = stk[-1]
        stk.pop()
        for v in adj[u]:
            if v != p and res[v] == -1:
                res[v] = 1 - res[u]
                stk.append((v, u))

for i in range(1, n+1):
    if res[i] == -1:
        res[i] = 1
        dfs(i, -1)

for i in range(m):
    if res[x[i]] == res[y[i]]:
        print(-1)
        exit()

print(res.count(0))
print(*[i for i in range(n+1) if res[i] == 0])
print(res.count(1))
print(*[i for i in range(n+1) if res[i] == 1])
