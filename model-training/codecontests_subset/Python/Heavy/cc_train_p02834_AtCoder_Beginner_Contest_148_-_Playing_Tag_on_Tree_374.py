import sys
sys.setrecursionlimit(10**7)

def dfs(v, d=0, p=-1):
    global dist
    dist[v] = d
    for u in to[v]:
        if u == p:
            continue
        dfs(u, d+1, v)


def calcDist(s):
    global dist
    dist = [0 for _ in range(N)]
    dfs(s)
    return dist


N, s, t = map(int, input().split())
s -= 1
t -= 1
to = [[] for _ in range(N)]
dist = [0 for _ in range(N)]


for i in range(N-1):
    a, b = map(int, input().split())
    a -= 1
    b -= 1
    to[a].append(b)
    to[b].append(a)

distS = calcDist(s)
distT = calcDist(t)

mx = 0
for i in range(N):
    if distS[i] < distT[i]:
        mx = max(mx, distT[i])

ans = mx - 1
print(ans)


