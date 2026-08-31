from collections import deque
N, u, v = map(int, input().split())
AB = [list(map(int, input().split())) for i in range(N-1)]

graph = [[] for i in range(N+1)]
for i,j in AB:
    graph[i].append(j)
    graph[j].append(i)
    
r = [-1 for i in range(N+1)] 
Q = deque()
Q.append(u)
r[u] = 0

while Q:
    x = Q.pop()
    for to in graph[x]:
        if r[to] == -1:
            r[to] = r[x] + 1
            Q.append(to)
            
c = [-1 for i in range(N+1)]  
Q=deque()
Q.append(v)
c[v] = 0

while Q:
    x = Q.pop()
    for to in graph[x]:
        if c[to] == -1:
            c[to] = c[x] + 1
            Q.append(to)
ans = 0            
for i in range(N+1):
    if r[i] < c[i]:
        ans = max(ans, c[i])

print(max(0, ans-1))