import sys
sys.setrecursionlimit(10**8)

def dfs(v, dist, d = 0, p = -1):
#     print(v, d)
    dist[v] = d
    for u in to[v]:
        if u == p:
            continue
        dfs(u, dist, d + 1, v)
def calcDist(s, dist):
    dfs(s, dist)        
n, u, v = map(int, input().split())
u -= 1
v -= 1
to = [[] for _ in range(n + 1)]
for i in range(n - 1):
    a, b = map(int, input().split())
    a -= 1
    b -= 1
    to[a].append(b)
    to[b].append(a)
distS = [0] * n
distT = [0] * n
calcDist(u, distS)
calcDist(v, distT)
mx = 0
for i in range(n):
    if distS[i] < distT[i]:
        mx = max(mx, distT[i])
ans = mx - 1
print(ans)