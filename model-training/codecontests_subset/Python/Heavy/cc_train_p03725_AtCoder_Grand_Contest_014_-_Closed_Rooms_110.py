import sys
sys.setrecursionlimit(500000) #これがないと再帰の回数オーバーでエラー出る。
from collections import deque
INF = float("inf")
H,W,K = map(int,input().split())
Room = []
for i in range(H):
  temp = str(input())
  temp = list(temp)
  for j in range(W):
    if temp[j] == "S":
      sx = i;sy =j
  Room.append(temp)
#print(sx,sy)
d = [(1,0),(-1,0),(0,1),(0,-1)]

R = [[INF]*W for _ in range(H)]
R[sx][sy] = 0
reach = set([])
reach.add((sx,sy))
Q = deque([[sx,sy]])
while Q:
  x,y = Q.popleft()
  if x==0 or x==H-1 or y==0 or y==W-1:
    print(1)
    exit()
  if R[x][y] == K:
    #L.add((x,y))
    #if stp == K:
    continue
  #stp +=1
  for i in range(4):
    nx = x+d[i][0]
    ny = y+d[i][1]
    #print(nx,ny)
    if nx<0 or nx>=H or ny<0 or ny>= W or Room[nx][ny] == "#" or R[nx][ny] != INF:
      continue
    reach.add((nx,ny))
    R[nx][ny] = R[x][y] + 1
    Q.append([nx, ny])
    #print(Q)

ans = INF

for t in reach:
  x,y = t[0],t[1]
  nokori = min(x,H-1-x,y,W-1-y)
  step = (nokori+K-1)//K + 1 #1は最初のステップ
  ans = min(ans,step)
print(ans)
        
        
        
              