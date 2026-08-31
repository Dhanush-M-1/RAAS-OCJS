import sys, os.path
from collections import*
from heapq import *
from copy import*
import math
mod=10**9+7
read = lambda: map(int, input().split())
if(os.path.exists('input.txt')):
    sys.stdin = open("input.txt","r")
    sys.stdout = open("output.txt","w") 

l1=[0,0,1,1,1,-1,-1,-1]
l2=[1,-1,-1,0,1,-1,0,1]

x1,y1,x2,y2=read()
n=int(input())
path=defaultdict(int)
for i in range(n):
    r,a,b=read()
    for j in range(a,b+1):
        path[(r,j)]=1
vis=defaultdict(int)
q=deque()
q.append((x1,y1))
vis[(x1,x2)]=1
dis=defaultdict(int)
dis[(x1,y1)]=0
flag=0
while(len(q)):
    x,y=q.popleft()
    for k in range(8):
        p1,p2=x+l1[k],y+l2[k]
        if not vis[(p1,p2)] and path[(p1,p2)]==1:
            q.append((p1,p2))
            dis[(p1,p2)]=dis[(x,y)]+1
            vis[(p1,p2)]=1
            if (p1,p2)==(x2,y2):
                flag=1
                break
    if(flag==1):
        break
ans=dis[(x2,y2)]
if(ans==0):
    print(-1)
else:
    print(ans)