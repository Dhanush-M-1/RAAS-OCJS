import math
import time
from collections import defaultdict,deque
from sys import stdin,stdout
from bisect import bisect_left,bisect_right
from queue import PriorityQueue 
import sys

n,m=map(int,stdin.readline().split())
graph=defaultdict(lambda:[])
for _ in range(m):
    x,y=map(int,stdin.readline().split())
    graph[x].append(y)
    graph[y].append(x)
poss=True
visited=[False]*(n+2)
colour=[-1]*(n+2)
for i in range(1,n+1):
    if(not visited[i] and len(graph[i])>0):
        visited[i]=True
        q=deque()
        q.append(i)
        colour[i]=0
        while(len(q)>0):
            temp=q.popleft()
            # print(temp,"temp")
            for j in graph[temp]:
                if(not visited[j]):
                    visited[j]=True
                    q.append(j)
                    colour[j]=1-colour[temp]
                elif(colour[j]==colour[temp]):
                    # print(j,temp,"hii")
                    poss=False
                    break
# print(colour)
if(poss):
    one=[]
    zero=[]
    for i in range(len(colour)):
        if(colour[i]==0):
            zero.append(i)
        elif(colour[i]==1):
            one.append(i)
    print(len(one))
    print(*one)
    print(len(zero))
    print(*zero)

else:
    print(-1)


        
