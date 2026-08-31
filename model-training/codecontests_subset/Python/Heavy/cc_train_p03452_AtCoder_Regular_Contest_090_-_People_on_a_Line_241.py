import sys
input = sys.stdin.readline
from collections import *

def bfs(s):
    q = deque([s])
    visited[s] = True
    
    while q:
        v = q.popleft()
        
        for nv, d in G[v]:
            if visited[nv]:
                if dist[v]+d!=dist[nv]:
                    print('No')
                    exit()
            else:
                visited[nv] = True
                dist[nv] = dist[v]+d
                q.append(nv)

N, M = map(int, input().split())
G = [[] for _ in range(N)]

for _ in range(M):
    L, R, D = map(int, input().split())
    G[L-1].append((R-1, D))
    G[R-1].append((L-1, -D))
    
visited = [False]*N
dist = [0]*N

for i in range(N):
    if not visited[i]:
        bfs(i)

print('Yes')