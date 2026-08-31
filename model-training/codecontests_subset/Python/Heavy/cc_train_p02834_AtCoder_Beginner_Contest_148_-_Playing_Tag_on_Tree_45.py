from sys import setrecursionlimit
setrecursionlimit(10 ** 5)

n, u, v = map(int, input().split())
ab = [tuple(map(lambda x:int(x)-1, input().split())) for _ in range(n-1)]
u -= 1
v -= 1

e = [[] for _ in range(n)]
for a, b in ab:
    e[a].append(b)
    e[b].append(a)

t = [0] * n
a = [0] * n

def dfs(x, p, d, c):
    if len(e[x]) == 1:
        if e[x][0] == p:
            return
    for y in e[x]:
        if y == p:
            continue
        if c == 0:
            t[y] = d
        else:
            a[y] = d
        dfs(y, x, d+1, c)

dfs(u, -1, 1, 0)
dfs(v, -1, 1, 1)
ans = 0
for i in range(n):
    if t[i] < a[i]:
        ans = max(a[i], ans)

print(ans-1)