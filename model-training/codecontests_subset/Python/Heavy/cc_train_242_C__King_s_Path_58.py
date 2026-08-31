import sys
from collections import deque
input=sys.stdin.readline
sx,sy,gx,gy=map(int,input().split())
n=int(input())
rab=[list(map(int,input().split())) for i in range(n)]
good=set()
vis={}
for r,a,b in rab:
    for c in range(a,b+1):
        good.add((r,c))
dq=deque()
dq.append([sx,sy,0])
vis[(sx,sy)]=0
while dq:
    x,y,c=dq.popleft()
    for dx in [-1,0,1]:
        for dy in [-1,0,1]:
            if dx==dy==0:
                continue
            pos=(x+dx,y+dy)
            if pos in good and not pos in vis:
                vis[pos]=c+1
                dq.append([x+dx,y+dy,c+1])
if (gx,gy) in vis:
    print(vis[(gx,gy)])
else:
    print(-1)