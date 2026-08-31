import sys
from collections import defaultdict
import heapq

g = defaultdict(list)
input = sys.stdin.buffer.readline
N,u,v= map(int,input().split())
for i in [0]*(N-1):
    A,B = map(int,input().split())
    g[A].append(B)
    g[B].append(A)

def dijkstra(start):
    inf = 10**10
    d = [inf]*(N+1)
    d[start] = 0
    que = []
    heapq.heappush(que,(start,0))
    while que:
        s, dist = heapq.heappop(que)
        if d[s] < dist:
            continue
        for t in g[s]:
            if d[t] > d[s] + 1:
                d[t] = d[s] + 1
                heapq.heappush(que,(t,d[t]))
    return d

d1 = dijkstra(u)
d2 = dijkstra(v)
ans = 0
for i in range(1,N+1):
    if d1[i] < d2[i]:
        ans = max(ans,d2[i]-1)
print(ans)



