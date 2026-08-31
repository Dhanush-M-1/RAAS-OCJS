from collections import deque
import math

#入力
h,w,k=map(int,input().split())
a=[input() for i in range(h)]

for i in range(h):
  for j in range(w):
    if a[i][j]=='S':
      sy,sx=i,j

d=deque([[sy,sx]])
dist=[]
inf=-1
m=1000
for i in range(h):
  dist.append([inf]*w)
dist[sy][sx]=0

while len(d)!=0:
  b=d.popleft()
  p,q=b[0],b[1]
  for i in [[1,0],[0,-1],[-1,0],[0,1]]:
    by,bx=b[0]+i[0],b[1]+i[1]
    if bx>=0 and bx<w and by>=0 and by<h:
      if a[by][bx]!='#' and dist[by][bx]==-1:
        d.append([by,bx])
        dist[by][bx]=dist[p][q]+1

for i in range(h):
  for j in range(w):
    if dist[i][j]!=-1 and dist[i][j]<=k:
      m=min(m,0--min(i,h-1-i,j,w-1-j)//k)

print(m+1)