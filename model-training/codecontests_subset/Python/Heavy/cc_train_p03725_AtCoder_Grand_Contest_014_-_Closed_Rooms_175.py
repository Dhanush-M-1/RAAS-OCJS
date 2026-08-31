from collections import deque
from math import ceil
H,W,K=map(int,input().split())
grid=[input() for i in range(H)]

for i in range(H):
  for j in range(W):
    if grid[i][j]=="S":
      S=(i,j)

stack=deque([(S[0],S[1],0)])
visited=[[False]*(W) for i in range(H)]
visited[S[0]][S[1]]=True
a=float("inf")
t=[-1,1]
while stack:
  i,j,m=stack.popleft()
  if m>K:
    break
  a=min(a,min(i,H-1-i,j,W-1-j))
  if a==0:
    break
  for s in t:
    if not visited[i+s][j] and grid[i+s][j]!="#":
      stack.append((i+s,j,m+1))
    if not visited[i][j+s] and grid[i][j+s]!="#":
      stack.append((i,j+s,m+1))
    visited[i+s][j]=True
    visited[i][j+s]=True
ans=1+ceil(a/K)
print(ans)


    
        
        
          
  
