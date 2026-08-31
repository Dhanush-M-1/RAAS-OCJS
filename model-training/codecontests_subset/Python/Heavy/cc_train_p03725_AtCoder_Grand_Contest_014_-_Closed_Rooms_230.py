h,w,k=map(int,input().split())
b=[]
v=[[0]*w for _ in range(h)]
sh=0
sw=0
for i in range(h):
    s=list(input())
    b.append(s)
    
    if 'S' in s:
        sh=i
        sw=s.index('S')
#ans=10**18
d=[[0,1],[1,0],[-1,0],[0,-1]]

def bfs(y,x):
    ans=10**18
    c=0
    q=[(y,x)]
    v[y][x]=1
    ans=min(y,x,h-1-y,w-1-x)
    while c<k:
        p=[]
        c+=1
        for i,j in q:
            for di,dj in d:
                if 0<=i+di<h and 0<=j+dj<w and v[i+di][j+dj]!=1 and b[i+di][j+dj]!='#':
                    p.append((i+di,j+dj))
                    v[i+di][j+dj]=1
                    ans=min(ans,i+di,j+dj,h-1-i-di,w-1-j-dj)
        q=p
    return ans
ans=bfs(sh,sw)
print(1+(ans+k-1)//k)
