from sys import stdin
input=stdin.readline
n,m=map(int,input().split())
g=[[] for _ in range(n)]
edge=[list(map(int,input().split())) for i in range(m)]
for u,v in edge:
  g[u-1].append(v-1)
  g[v-1].append(u-1)
s=[-1]*n
def bfs(ver,col):
  q=[(ver,col)]
  while q:
    x,c=q.pop()
    if s[x]==-1:
      s[x]=c
      for to in g[x]:
        if s[to]==-1:
          q.append((to,1-c))
for i in range(n):
  if s[i]==-1:
    bfs(i,0)
for u,v in edge:
  if s[u-1]==s[v-1]:
    print(-1)
    break
else:
  a=[i+1 for i in range(n) if s[i]==0]
  b=[i+1 for i in range(n) if s[i]==1]
  print(len(a))
  print(*a)
  print(len(b))
  print(*b)
