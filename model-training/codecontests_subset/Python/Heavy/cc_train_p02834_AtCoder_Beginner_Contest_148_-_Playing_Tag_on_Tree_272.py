from collections import deque
n, u, v = map(int, input().split())
Tree = [ [] for _ in range(n) ]

def calc(s, tree):
    S = deque([s])
    Dist = [-1]*n
    Dist[s] = 0
    while S:
        u = S.pop()
        for v in tree[u]:
            if Dist[v] < 0:
                Dist[v] = Dist[u] + 1
                S.append(v)
    return Dist

for _ in range(n-1):
    a, b = map(int, input().split())
    Tree[a-1].append(b-1)
    Tree[b-1].append(a-1)
uDist, vDist = calc(u-1, Tree), calc(v-1, Tree)

ans = 0
for i in range(n):
    if uDist[i] < vDist[i]:
        ans = max(ans, vDist[i]-1)
print(ans)