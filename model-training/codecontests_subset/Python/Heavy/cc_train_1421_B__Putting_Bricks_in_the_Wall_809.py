# Author : -pratyay- #
import sys
inp=sys.stdin.buffer.readline
inar=lambda: list(map(int,inp().split()))
inin=lambda: int(inp())
inst=lambda: inp().decode().strip()
wrt=sys.stdout.write
pr=lambda *args,end='\n': wrt(' '.join([str(x) for x in args])+end)
enum=enumerate; inf=float('inf')
cdiv=lambda x,y: (-(-x//y))
# Am I debugging ? Check if I'm using same variable name in two places
# fun() returning empty list ? check new=temp[:] or new=temp
mod=1000000007

'''def DFS(gr):
    pth0=[]
    pth1=[]
    path=[]
    vis=[[False for i in range(n)] for i in range(n)]
    def dfs(x,y):
        path.append((x,y))
        vis[x][y]=True 
        for dx,dy in zip([],[])'''

_T_=inin()
for _t_ in range(_T_):
    n=inin()
    gr=[]
    for i in range(n):
        gr.append(inst())
    #DFS(gr)
    p01=[]
    p10=[]
    fr=[(-1,-3),(-2,-2),(-3,-1)]
    sr=[(-1,-2),(-2,-1)]
    for i,j in fr:
        if gr[i][j]=='1':
            p01.append((i,j))
        else:
            p10.append((i,j))
    for i,j in sr:
        if gr[i][j]=='1':
            p10.append((i,j))
        else:
            p01.append((i,j))
    #pr(p01,p10)
    if len(p01)<=2 and len(p10)<=2:
        if len(p01)>len(p10):
            pr(len(p01))
            for i,j in p01:
                pr(n+i+1,n+j+1)
        else:
            pr(len(p10))
            for i,j in p10:
                pr(n+i+1,n+j+1)

    elif len(p01)<len(p10):
        pr(len(p01))
        for i,j in p01:
            pr(n+i+1,n+j+1)
    else:
        pr(len(p10))
        for i,j in p10:
            pr(n+i+1,n+j+1)