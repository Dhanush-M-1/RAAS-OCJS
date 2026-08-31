import heapq
import sys
sys.setrecursionlimit(10**6)
 
N,u,v = map(int, input().split())
 
es = [[] for _ in range(N+1)]
 
for i in range(N-1):
    a,b = map(int, input().split())
    es[a].append(b)
    es[b].append(a)
 
INF = float("inf")
from_u = [INF] * (N+1)
from_u[u] = -1
from_v = [INF] * (N+1)
from_v[v] = -1
 
def solve(prev, curr, distances):
    distances[curr] = distances[prev] + 1
    for next in es[curr]:
        if distances[next] == INF:
            solve(curr, next, distances)
 
solve(u,u,from_u)
solve(v,v,from_v)
 
 
 
ans = 0
for i in range(1,N+1):
    if from_u[i] < from_v[i]:
        # 追い詰めた段階で高橋君が自ら青木君のマスに戻ってくるので、最後の端っこまで追い詰めなくていいから-1
        ans = max(ans, from_v[i]-1)
 
print(ans)