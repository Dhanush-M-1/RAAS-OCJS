from collections import deque
n, u, v = list(map(int, input().split()))
a = [[] for _ in range(n+1)]
for _ in range(n-1):
  x, y = map(int, input().split())
  a[x].append(y)
  a[y].append(x)
  
def dis(a,v):
  d = [[1,0] for _ in range(n+1)]
  c = 1
  for i in a[v]:
    d[i][0] = 1
    d[i][1] = c
    c += 1
  b = deque(a[v])
  while b:
    x = b.pop()
    for i in a[x]:
      if d[i][1] == 0:
        d[i][0] = d[x][0] + 1
        d[i][1] = d[x][1]
        b.append(i)
  d[v] = [0,0]
  return d

du = dis(a,u)
dv = dis(a,v)
dis = max([dv[i][0] for i in range(n+1) if dv[i][1]==dv[u][1] and dv[i][0]>du[i][0]])
print(dis-1)