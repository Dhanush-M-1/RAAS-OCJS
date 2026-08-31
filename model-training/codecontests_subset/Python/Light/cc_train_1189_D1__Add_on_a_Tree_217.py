n = int(input())

g = [[] for i in range(n)]
for i in range(n - 1):
    u, v = map(int, input().split())
    u -= 1
    v -= 1
    g[u].append(v)
    g[v].append(u)
for v in range(n):
    if len(g[v]) == 2:
        print('NO')
        exit(0)
print('YES')
        