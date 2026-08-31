
# グラフ問題での分析が全然できなかった（初体験）
# 次回は頑張って解く！
# 解説動画をみることがMUST、基本そのまま書いている。

from heapq import heappop, heappush
N, u, v = map(int, input().split())
edges = [[] for i in range(N+1)]

for i in range(N-1):
  a, b = map(int, input().split())
  edges[a].append(b)
  edges[b].append(a)

def dfs(u):
  colors = ["white"] * (N+1)
  d = [9999999999999999] * (N + 1)
  d[u] = 0
  stack = [u]

  while stack:
    u = stack.pop()
    colors[u] = "black"

    for e in edges[u]:
      if colors[e] != "black":
        d[e] = d[u] + 1
        stack.append(e)

  return d

u_dist = dfs(u)
v_dist = dfs(v)

ans = 0
for i in range(N+1):
  if u_dist[i] < v_dist[i]:
    ans = max(ans, v_dist[i] - 1)

print(ans)