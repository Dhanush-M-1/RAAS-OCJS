N, u, v = map(int, input().split())
edge = [set() for i in range(N)]

u -= 1
v -= 1

for i in range(N-1):
  a, b = map(int, input().split())
  edge[a-1].add(b-1)
  edge[b-1].add(a-1)

def calcDepth(root):
  depth = [-1] * N
  stack = [(root, 0)]

  while stack:
    cur, curD = stack.pop()
    depth[cur] = curD
    for c in edge[cur]:
      if depth[c] != -1: continue
      stack.append((c, curD+1))
  
  return depth

Adepth = calcDepth(v)
Ddepth = calcDepth(u)

ans = 0
for i in range(N):
  if Adepth[i] >= Ddepth[i]:
    ans = max(ans, Adepth[i])
print(ans-1)