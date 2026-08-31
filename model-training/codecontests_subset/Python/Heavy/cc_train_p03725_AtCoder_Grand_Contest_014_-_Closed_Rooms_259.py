from collections import deque

H,W,K=map(int,input().split())
A=["" for i in range(H)]
for i in range(H):
    A[i]=input()

for i in range(H):
    for j in range(W):
        if A[i][j]=="S":
            s=(i,j)

move=[(0,1),(1,0),(0,-1),(-1,0)]
start=set([s])
que=deque([(0,s[0],s[1])])
while que:
    count,posx,posy=que.popleft()
    if count==K:
        continue

    for i,j in move:
        nx=posx+i;ny=posy+j
        if H-1>=nx>=0 and W-1>=ny>=0 and A[nx][ny]!="#" and (nx,ny) not in start:
            start.add((nx,ny))
            que.append((count+1,nx,ny))


ans=float("inf")
for x,y in start:
    test=1+min((abs(x-0)-1)//K+1,(abs(H-1-x)-1)//K+1,(abs(y-0)-1)//K+1,(abs(W-1-y)-1)//K+1)
    ans=min(ans,test)

if s[0]==0 or s[0]==H-1 or s[1]==0 or s[1]==W-1:
    ans=0
print(ans)