import sys
sys.setrecursionlimit(1000000)
N, u, v = map(int, input().split())
G = {k: [] for k in range(N+1)}
for _ in range(N-1):
    a, b = map(int, input().split())
    # 無向グラフ
    G[a].append(b)
    G[b].append(a)


def dfs(ci, d, p, dist):
    dist[ci] = d
    for ni in G[ci]:
        if ni == p:
            continue
        dfs(ni, d+1, ci, dist)


def calcDist(start):
    dist = [-1]*(N+1)
    dfs(start, 0, -1, dist)
    return dist


distU = calcDist(u)
distV = calcDist(v)

ans = 0
for i in range(1, N+1):
    if distU[i] < distV[i]:
        ans = max(ans, distV[i]-1)
print(ans)
