#148_F
import queue
n, u, v = map(int, input().split())
inf = 10 ** 6
ans = 0

edges = [[] for _ in range(n)]
for _ in range(n-1):
    a, b = map(int, input().split())
    edges[a-1].append(b-1)
    edges[b-1].append(a-1)

def bfs(d,start):
    d[start] = 0
    que = queue.Queue()
    que.put(start)
    while not que.empty():
            x = que.get()
            for to in edges[x]:
                if d[to] == inf:
                    que.put(to)
                    d[to] = d[x] + 1
                    
du, dv = [inf]*n, [inf]*n
bfs(du,u-1)
bfs(dv,v-1)
for i in range(n):
    if dv[i] > du[i]:
        ans = max(ans, dv[i] - 1)
    
print(ans)