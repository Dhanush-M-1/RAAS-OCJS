n,m=map(int,input().split())
a=[0]*n
b=[0]*n
for i in range(n):
  a[i],b[i]=map(int,input().split())
c=[0]*m
d=[0]*m
for j in range(m):
  c[j],d[j]=map(int,input().split())
e=[0]*n
g=[0]*m
for k in range(n):
  for l in range(m):
    g[l]=abs(a[k]-c[l])+abs(b[k]-d[l])
  e[k]=int(g.index(min(g))+1)
  print(e[k])