from collections import deque

# <IO>
import os
import sys
from atexit import register
from io import BytesIO
 
sys.stdin = BytesIO(os.read(0, os.fstat(0).st_size))
input = lambda: sys.stdin.readline().rstrip()
 
sys.stdout = BytesIO()
register(lambda: os.write(1, sys.stdout.getvalue()))
# </IO>

n = int(input())

g = [[] for _ in range(n)] # adjacency lists
for _ in range(n - 1):
    v, to = map(int, input().split())
    v -= 1
    to -= 1
    g[v].append(to)
    g[to].append(v)

root = 0
visited = [False] * n
cs = [[] for _ in range(n)]
queue = deque([root])
while queue:
    v = queue.popleft()
    if not visited[v]:
        visited[v] = True
        for to in g[v]:
            cs[v].append(to)
            queue.append(to)

visited = [False] * n
stack = [(0, root)]  # (depth, vertex)
traversal = []       # (depth, vertex)
enters = [-1] * n
while stack:
    depth, v = stack.pop()
    if not visited[v]:
        visited[v] = True
        enters[v] = len(traversal)
        for child in cs[v]:
            stack.append((depth, v))
            stack.append((depth + 1, child))
    traversal.append((depth, v))

N = len(traversal) # N=2n-1
k = 1              # min power of 2 >= N
while (1<<k) < N:
    k += 1

ST = [[float('inf')] * k for _ in range(N)]
for i in range(N):
    ST[i][0] = traversal[i]
for j in range(1, k):
    for i in range(N):
        if i + (1<<j) > N:
            continue
        ST[i][j] = min(ST[i][j - 1], ST[i + (1<<(j-1))][j - 1])

log_len = [0] * (N + 1)
for i in range(2, N + 1):
    log_len[i] = log_len[i>>1] + 1
# print(k, 1<<k, N)

q = int(input())
for _ in range(q):
    x, y, a, b, k = map(int, input().split())
    x -= 1
    y -= 1
    a -= 1
    b -= 1
    
    Ia = enters[a]
    Ib = enters[b]
    da, _ = traversal[Ia]
    db, _ = traversal[Ib]
    L = min(Ia, Ib)
    R = max(Ia, Ib)
    j = log_len[R - L + 1]
    depth, lca = min(ST[L][j], ST[R - (1<<j) + 1][j])
    curr = da - depth + db - depth
    if curr <= k and (k - curr) % 2 == 0:
        sys.stdout.write('YES'.encode() + b'\n')
        continue
    
    Ix = enters[x]
    Iy = enters[y]
    dx, _ = traversal[Ix]
    dy, _ = traversal[Iy]
    
#     a - x - y - b
    L = min(Ia, Ix)
    R = max(Ia, Ix)
    j = log_len[R - L + 1]
    depth, lca = min(ST[L][j], ST[R - (1<<j) + 1][j])
    part_ax = da - depth + dx - depth
    
    L = min(Ib, Iy)
    R = max(Ib, Iy)
    j = log_len[R - L + 1]
    depth, lca = min(ST[L][j], ST[R - (1<<j) + 1][j])
    part_by = db - depth + dy - depth
    
    curr = part_ax + 1 + part_by
    if curr <= k and (k - curr) % 2 == 0:
        sys.stdout.write('YES'.encode() + b'\n')
        continue
    
#     a - y - x - b
    L = min(Ia, Iy)
    R = max(Ia, Iy)
    j = log_len[R - L + 1]
    depth, lca = min(ST[L][j], ST[R - (1<<j) + 1][j])
    part_ay = da - depth + dy - depth
    
    L = min(Ib, Ix)
    R = max(Ib, Ix)
    j = log_len[R - L + 1]
    depth, lca = min(ST[L][j], ST[R - (1<<j) + 1][j])
    part_bx = db - depth + dx - depth
    
    curr = part_ay + 1 + part_bx
    if curr <= k and (k - curr) % 2 == 0:
        sys.stdout.write('YES'.encode() + b'\n')
        continue
    
    sys.stdout.write('NO'.encode() + b'\n')
