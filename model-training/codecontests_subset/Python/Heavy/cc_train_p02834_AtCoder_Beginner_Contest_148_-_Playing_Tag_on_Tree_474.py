n,u,v = map(int,input().split())
u,v = u-1,v-1
link = [[] for i in range(n)]
for i in range(n-1):
  a,b = map(int,input().split())
  a,b = a-1,b-1
  link[a].append(b)
  link[b].append(a)
tree = [[] for i in range(n)]
for i in [u,v]:
  stack = [i]
  vi = [0] * n
  tree[i].append(0)
  vi[i] = 1
  while stack:
    cur = stack.pop()
    for j in link[cur]:
      if vi[j] == 0:
        stack.append(j)
        vi[j] = 1
        tree[j].append(tree[cur][-1]+1)
m = 0
c = 0
for i,j in tree:
  if i < j:
    if m < j:
      m = j
      #c = (j-i) % 2
print(m-1)