import sys
input = sys.stdin.readline
from collections import deque

def bfs(s):
    dist = [-1]*N
    dist[s] = 0
    q = deque([s])
    
    while q:
        v = q.popleft()
        
        for nv in adj_list[v]:
            if dist[nv]==-1:
                dist[nv] = dist[v]+1
                q.append(nv)
                
    return dist

N, u, v = map(int, input().split())
adj_list = [[] for _ in range(N)]

for _ in range(N-1):
    Ai, Bi = map(int, input().split())
    adj_list[Ai-1].append(Bi-1)
    adj_list[Bi-1].append(Ai-1)

d1 = bfs(u-1)
d2 = bfs(v-1)
ans = 0

for i in range(N):
    if d1[i]<d2[i]:
        ans = max(ans, d2[i]-1)

print(ans)