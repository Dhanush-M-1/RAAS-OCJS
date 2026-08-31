import sys
sys.setrecursionlimit(10**7)


N, u, v = map(int, input().split())
u -= 1
v -= 1

graph = [[] for _ in range(N)]
for i in range(N-1):
    a, b = map(int, input().split())
    a -= 1
    b -= 1
    graph[a].append(b)
    graph[b].append(a)


dist = []
def dfs(v, depth=0, parent=-1):
    global dist
    dist[v] = depth
    for u in graph[v]:
        # 親には行かないようにする
        if u == parent:
            continue
        dfs(u, depth + 1, v)


def calc_dist(s):
    global dist
    dist = [0 for _ in range(N)]
    dfs(s)
    return dist


distS = calc_dist(u)
distT = calc_dist(v)

mx = 0
for i in range(N):
    if distS[i] < distT[i]:
        mx = max(mx, distT[i])

print(mx - 1)
