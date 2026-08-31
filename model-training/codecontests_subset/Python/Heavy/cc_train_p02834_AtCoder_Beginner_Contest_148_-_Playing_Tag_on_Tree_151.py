from collections import deque

N, u, v  =  map(int, input().split())

ab_list = [
  tuple(map(int, input().split())) for _ in range(N - 1)
]

graph = [ [] for _ in range(N+1) ]

#双方向だから両矢印に。
for a, b in ab_list:
  graph[a].append(b)
  graph[b].append(a)
  
def dfs(v):
  dist = [-1] * (N+1)
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

#到達できる最小回数
DU = dfs(u)
DV = dfs(v)

answer = 0
for u, v in zip(DU[1:], DV[1:]):
  if u < v:
    #　到達できちゃう天を洗い出し
    x = v - 1
    answer = max(answer, x)

print(answer)