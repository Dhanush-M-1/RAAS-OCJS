import sys

stdin = sys.stdin
ns = lambda: stdin.readline().rstrip()
na = lambda: list(map(int, stdin.readline().split()))
ni = lambda: int(ns())
sys.setrecursionlimit(200000)

(n,u,v)=na()
u -= 1
v -= 1

g = [[] for _ in range(n)]

for i in range(0, n-1):
    (a, b) = na()
    g[a-1].append(b-1)
    g[b-1].append(a-1)


dep1 = [0] * n
dep2 = [0] * n
def dfs(now, pre, d, dep):
    dep[now] = d
    for nex in g[now]:
        if pre == nex:
            continue
        dfs(nex,now,d+1,dep)


dfs(u, -1, 0, dep1)
dfs(v, -1, 0, dep2)

ret = 0
for i in range(n):
    if dep1[i] < dep2[i]:
        ret = max(ret, dep2[i]-1)
print(ret)
