import sys
sys.setrecursionlimit(10**6)

n,v,u = map(int, input().split()); u -= 1; v -= 1
g = [list() for _ in range(n)]
for _ in range(n-1):
  a,b = map(int, input().split())
  g[a-1].append(b-1)
  g[b-1].append(a-1)
dep = [0]*n; mdep = [0]*n; par = [-1]*n

if u == v: print(0); exit(0)

def dfs(v,p):
  for x in g[v]:
    if x == p:
      continue
    par[x] = v
    dep[x] = dep[v] + 1
    dfs(x,v)
    if mdep[v] < mdep[x] + 1:
      mdep[v] = mdep[x] + 1
  return
      
dfs(u,-1)
t = (dep[v]-1)//2
curv = v
for _ in range(t):
  curv = par[curv]
curu = par[curv]
if not dep[v]%2:
  curu = par[curu]
print(t + mdep[curv] + 1 - dep[v]%2)