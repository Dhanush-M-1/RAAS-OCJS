import sys
sys.setrecursionlimit(10**6)

n, T, A = map(int, input().split())
T -= 1; A -= 1
g = [list() for i in range(n)]
for _ in range(n-1):
    a, b = map(int, input().split())
    a -= 1; b -= 1
    g[a].append(b)
    g[b].append(a)

dist_r = [0] * n
dist_t = [0] * n

def dfs(v, p, dist):
    dist_r[v] = dist
    ret = 0
    for nv in g[v]:
        if nv == p: continue
        ret = max(ret, dfs(nv, v, dist+1))
    dist_t[v] = ret
    return ret + 1

dfs(A, -1, 0)

init_dist = dist_r[T]
v = T
d1 = 0
d2 = init_dist
while init_dist - dist_r[v] < dist_r[v]:
    if d1 < dist_t[v]:
        d1 = dist_t[v]
        d2 = dist_r[v]
    for nv in g[v]:
        if dist_r[v] > dist_r[nv]:
            v = nv
            break

print(d1+d2-1)