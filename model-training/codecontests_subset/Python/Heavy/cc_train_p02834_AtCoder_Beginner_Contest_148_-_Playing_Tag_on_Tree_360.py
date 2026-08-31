import sys
n,u,v=map(int,input().split())
sys.setrecursionlimit(10**9)
tree=[[] for i in range(n)]
for i in range(n-1):
  a,b=map(int,input().split())
  tree[a-1].append(b-1)
  tree[b-1].append(a-1)
a=[None]*n
t=[None]*n
t[u-1]=0
a[v-1]=0
def dfsA(x,c):
  for i in tree[x]:
    if a[i]==None:
      a[i]=c
      dfsA(i,c+1)
dfsA(v-1,1)
k=a[u-1]
def dfsT(x,c):
  global k
  for i in tree[x]:
    if t[i]==None and c<a[i]:
      t[i]=c
      if k<a[i]:
        k=a[i]
      dfsT(i,c+1)
dfsT(u-1,1)
print(k-1)