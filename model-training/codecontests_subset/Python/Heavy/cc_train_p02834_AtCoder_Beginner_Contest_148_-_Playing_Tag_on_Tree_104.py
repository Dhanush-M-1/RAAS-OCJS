import sys
input = sys.stdin.readline
I=lambda:int(input())
MI=lambda:map(int,input().split())
LI=lambda:list(map(int,input().split()))
from collections import deque

res=0
INF=10**9


N,u,v=MI()
G=[[] for _ in [0]*(N+1)]
for i in range(N-1):
    a,b=MI()
    G[a].append(b)
    G[b].append(a)


def bfs(a):
    q=deque()
    q.append(a)
    d=[INF]*(N+1)
    d[a]=0
    res=0
    while q:
        r=q.popleft()
        for nr in G[r]:
            if d[nr]==INF:
                q.append(nr)
                d[nr]=d[r]+1
                res+=1
    return d

aoki=bfs(v)
taka=bfs(u)

m=0
for i in range(1,N+1):
    if taka[i]<aoki[i]:
        m=max(aoki[i],m)
print(m-1)