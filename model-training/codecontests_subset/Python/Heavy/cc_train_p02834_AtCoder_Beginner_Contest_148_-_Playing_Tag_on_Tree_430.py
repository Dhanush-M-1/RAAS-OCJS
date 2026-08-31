n, u, v = map(int, input().split())
u, v = u-1, v-1

g = [[] for i in range(n)]

for i in range(n-1):
  a, b = map(int, input().split())
  a, b = a-1, b-1
  g[a].append(b)
  g[b].append(a)
  
  
dt = [-1]*n
da = [-1]*n

from collections import deque
def dfs(g, s, d_list):
  stack = deque()
  stack.append(s)
  d_list[s] = 0
  while stack:
    x = stack.pop()
    for new_x in g[x]:
      if d_list[new_x] == -1:
        stack.append(new_x)
        d_list[new_x] = d_list[x]+1
  return d_list

dt = dfs(g, u, dt)
da = dfs(g, v, da)

d = 0
for i in range(n):
  if dt[i] < da[i]:
    d = max(d, da[i])
    
print(d-1)