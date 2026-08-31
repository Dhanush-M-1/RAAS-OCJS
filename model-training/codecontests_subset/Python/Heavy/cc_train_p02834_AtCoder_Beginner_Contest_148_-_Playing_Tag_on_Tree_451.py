import sys
sys.setrecursionlimit(700000)

from collections import deque

N, u, v = map(int, input().split())
tree = deque([deque() for i in range(N+1)])

def dfs(s, dist, d=0, p=-1):
    dist[s] = d
    for tmp in tree[s]:
        if tmp != p:
            dfs(tmp, dist, d+1, s)

for i in range(N-1):
    A, B = map(int, input().split())
    tree[A-1].append(B-1)
    tree[B-1].append(A-1)

distT, distA = [0]*N, [0]*N

dfs(u-1, distT)
dfs(v-1, distA)

ans = 0
for i in range(N):
    if distT[i] < distA[i]:
        ans = max(ans, distA[i])
print(ans-1)