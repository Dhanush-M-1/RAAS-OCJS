from collections import deque
import sys
sys.setrecursionlimit(10**7)
 
N,M=map(int,input().split())
Graph=[[] for i in range(N)]
for i in range(M):
  L,R,D=map(int,input().split())
  Graph[L-1].append((R-1,D))
  Graph[R-1].append((L-1,-D))
visit=[False]*N
dist=[0]*N
 

for i in range(N):
  if not visit[i]:
    visit[i]=True
    A=deque()
    A.append(i)
    while A:
      x=A.pop()
      for y,d in Graph[x]:
        if visit[y] and (dist[y]!=d+dist[x]):
          print('No')
          exit()
        elif not visit[y]:
          visit[y]=True
          A.append(y)
          dist[y]=d+dist[x]
print('Yes')