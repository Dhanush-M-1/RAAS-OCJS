n, u, v = map(int, input().split())
u -= 1
v -= 1
g = [[] for _ in range(n)]
for i in range(n-1):
    a, b = map(int, input().split())
    a, b = a-1, b-1
    g[a].append(b)
    g[b].append(a)

from collections import deque
q = deque()
q.append(u)
t = [-1]*n
t[u] = 0
while q:
    x = q.popleft()
    for new_x in g[x]:
        if t[new_x] == -1:
            t[new_x] = t[x]+1
            q.append(new_x)

q = deque()
q.append(v)
a = [-1]*n
a[v] = 0
while q:
    x = q.popleft()
    for new_x in g[x]:
        if a[new_x] == -1:
            a[new_x] = a[x]+1
            q.append(new_x)
            
max_ = 0
for i in range(n):
    if t[i] < a[i]:
        max_ = max(max_, a[i])
print(max_-1)