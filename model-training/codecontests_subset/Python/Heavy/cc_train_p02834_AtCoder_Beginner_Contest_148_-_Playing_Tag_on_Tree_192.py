import sys
input = sys.stdin.readline
 
# 再帰上限を引き上げる
sys.setrecursionlimit(10**6)

n, u, v = map(int, input().split())
u, v = u-1, v-1
l = [[] for i in range(n)]
for i in range(n-1):
  a, b = map(int, input().split())
  a, b = a-1, b-1
  l[a].append(b)
  l[b].append(a)

def dfs(G, cr, seen, dist):
  seen[cr] = 1
  for i in G[cr]:
    if seen[i] == 0:
      dist[i] = dist[cr] + 1
      dfs(G, i, seen, dist)
  return dist

seen_u = [0]*n
seen_v = [0]*n
dist_u = [0]*n
dist_v = [0]*n

T1 = dfs(l, u, seen_u, dist_u)
T2 = dfs(l, v, seen_v, dist_v)

for i in range(n):
  if dist_u[i] >= dist_v[i]:
    dist_v[i] = -1
    
print(max(dist_v)-1)