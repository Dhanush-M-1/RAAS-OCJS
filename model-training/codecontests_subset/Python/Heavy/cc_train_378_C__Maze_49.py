from collections import deque


def neighbours(v):
    out = set()
    x, y = v
    if 0 <= x + 1 < m and 0 <= y < n:
        out.add((x + 1, y))
    if 0 <= x - 1 < m and 0 <= y < n:
        out.add((x - 1, y))
    if 0 <= x < m and 0 <= y + 1 < n:
        out.add((x, y + 1))
    if 0 <= x < m and 0 <= y - 1 < n:
        out.add((x, y - 1))
    return out

def bfs(v):
    queue = deque([v])
    visited_dots = 0
    while queue:
        vx, vy = queue.popleft()
        if g[vy][vx] == 2:
            continue
        g[vy][vx] = 2
        visited_dots += 1
        if visited_dots == dots - k:
            return
        for ux, uy in neighbours((vx, vy)):
            if g[uy][ux] == 0:    
                queue.append((ux, uy))

n, m, k = map(int, input().split())
g = []
visited = set()
dots = 0
v = None
for j in range(n):
    s = list(map(lambda x: 0 if x == '.' else 1, input()))
    if not v and 0 in s:
        v = (s.index(0), j)
    dots += m - sum(s)
    g.append(s)

bfs(v)

for j in range(n):
    for i in range(m):
        if g[j][i] == 0:
            print('X', end='')
        elif g[j][i] == 1:
            print('#', end='')
        else:
            print('.', end='')
    print()
