from math import *
from collections import *
from random import *
from bisect import *
import sys
input=sys.stdin.readline
t=1
def bfs(deg,vis,cur,par):
    qu=deque([])
    qu.append([cur,0])
    while qu:
        x=qu.popleft()
        col[x[0]]=x[1]
        if(x[1] and vis[x[0]]==0):
            fi.append(x[0])
        elif(vis[x[0]]==0):
            se.append(x[0])
        vis[x[0]]=1
        for i in deg[x[0]]:
            if(vis[i]==0):
                qu.append([i,1^x[1]])
                par[i]=x[0]
            elif(col[x[0]]==col[i]):
                return 1
    return 0
while(t):
    t-=1
    n,m=map(int,input().split())
    deg=[[] for i in range(n+1)]
    vis=[0 for i in range(n+1)]
    par=[0 for i in range(1+n)]
    col=[0 for i in range(1+n)]
    fi=[]
    se=[]
    fl=0
    for i in range(m):
        x,y=map(int,input().split())
        deg[x].append(y)
        deg[y].append(x)
    for i in range(1,n+1):
        if(vis[i]==0):
            fl+=bfs(deg,vis,i,par)
   # print(fi,se,fl)
    if(fl or len(fi)==0 or len(se)==0):
        print(-1)
    else:
        print(len(fi))
        print(*fi)
        print(len(se))
        print(*se)
        
    
            
        
    
        
    
