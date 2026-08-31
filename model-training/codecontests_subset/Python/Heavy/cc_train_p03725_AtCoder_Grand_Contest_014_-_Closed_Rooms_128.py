h,w,k=map(int, input().split())
s=[list(input()) for i in range(h)]
p=[[-1]*w for i in range(h)]
for i in range(h):
    for j in range(w):
        if s[i][j]=='S':
            sta=(i,j)
np=[(1,0),(-1,0),(0,1),(0,-1)]
q={sta}
p[sta[0]][sta[1]]=0
step=0
while step<k and q:
    step+=1
    nq=set()
    while q:
        now=q.pop()
        for i,j in np:
            nx,ny=now[0]+i,now[1]+j
            if nx<0 or nx==h or ny<0 or ny==w:continue
            if s[nx][ny]=='.' and p[nx][ny]==-1:
                p[nx][ny]=step
                nq.add((nx,ny))
    q=nq.copy()

ans=10**9
for i in range(h):
    for j in range(w):
        if p[i][j]>=0:
            an=min(i,j,h-i-1,w-j-1)
            if ans>an:ans=an
print(-(-ans//k)+1)