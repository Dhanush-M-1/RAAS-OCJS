import sys
input = sys.stdin.readline
from collections import *

def bfs(s):
    q = deque([s])
    dist = [-1]*N
    dist[s] = 0
    
    while q:
        v = q.popleft()
        
        for nv in G[v]:
            if dist[nv]==-1:
                dist[nv] = dist[v]+1
                q.append(nv)
                
                if s==V-1:
                    is_leaf[v] = False
        
    return dist

N, U, V = map(int, input().split())
G = [[] for _ in range(N)]

for _ in range(N-1):
    A, B = map(int, input().split())
    G[A-1].append(B-1)
    G[B-1].append(A-1)

is_leaf = [True]*N
d1 = bfs(V-1)
d2 = bfs(U-1)
ans = 0

for i in range(N):
    if not is_leaf[i] and d2[i]<=d1[i]:
        ans = max(ans, d1[i])
    
print(ans)