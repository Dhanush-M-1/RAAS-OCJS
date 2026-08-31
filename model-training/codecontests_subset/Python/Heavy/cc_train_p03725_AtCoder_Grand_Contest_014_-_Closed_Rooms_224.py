from collections import *
H,W,K=map(int,input().split())
A=[list(input()) for i in range(H)]
SX,SY=0,0
for i in range(H):
  for j in range(W):
    if A[i][j]=='S':
      SX,SY=j,i
D=deque()
Z=set()
P=1
def qao(y,x):
  if min(x,y)==0 or x+1==W or y+1==H:
    print(P)
    exit()
  if (y,x) in Z:
    return False
  D.append((y,x))
  Z.add((y,x))
  return True

w4x=(1,0,-1,0)
w4y=(0,1,0,-1)
def bfs(F):
  v=0
  for i in range(len(D)):
    v=D.popleft()
    for j in range(4):
      if A[v[0]+w4y[j]][v[1]+w4x[j]]=='.' or F:
        qao(v[0]+w4y[j],v[1]+w4x[j])

qao(SY,SX)
for i in range(K):
  bfs(0)
D=deque(Z)
while True:
  P+=1
  for i in range(K):
    bfs(1)