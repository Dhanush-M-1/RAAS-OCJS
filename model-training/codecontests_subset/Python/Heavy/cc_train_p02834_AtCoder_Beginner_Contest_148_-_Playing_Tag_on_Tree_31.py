#入力
n, u, v = map(int, input().split())
mapdata = [list(map(int,input().split())) for _ in range(n-1)]

#グラフ作成
graph = [[] for _ in range(n+1)]
for i, j in mapdata:
  graph[i].append(j)
  graph[j].append(i)

#探索
def dfs(v):
  dist = [-1] * (n + 1)
  stack = [v]
  dist[v] = 0
  while stack:
    v = stack.pop()
    dw = dist[v] + 1
    for w in graph[v]:
      if dist[w] >= 0:
        continue
      dist[w] = dw
      stack.append(w)
  return dist

du, dv = dfs(u), dfs(v)
ans = 0

for u, v in zip(du[1:], dv[1:]):
  if u < v:
    x = v-1
    if ans < x:
      ans = x

print(ans)