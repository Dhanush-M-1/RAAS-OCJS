
h,w,k=map(int,input().split())
maze=[]

for i in range(h):
    maze.append(input())
    for j in range(w):
        if maze[i][j]=="S":x,y=i,j
    
ans=float("INF")
l=[[float("INF")]*w for i in range(h)]
l[x][y]=0
from collections import deque
dq=deque([(x,y)])
#pop/append/(append,pop)_left/in/len/count/[]/index/rotate()(右へnずらす)
p={(x,y)}
while len(dq):
    nx,ny=dq.popleft()
    for a,s in [(0,1),(0,-1),(1,0),(-1,0)]:
        if 0<=a+nx<h and 0<=ny+s<w and l[a+nx][s+ny]==float("INf")and maze[a+nx][s+ny]==".":
            l[a+nx][ny+s]=l[nx][ny]+1
            if l[a+nx][ny+s]<=k:p.add((a+nx,s+ny))
            if l[a+nx][ny+s]<k:dq.append((a+nx,s+ny))
ans=float("INf")

for x,y in p:
    ans=min(ans,(min(x,y,h-1-x,w-1-y)+k-1)//k+1)
print(ans)