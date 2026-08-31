from collections import deque
import sys
input = sys.stdin.readline

def bfs(s):
    que = deque([(0, s)])
    while que:
        d, v = que.popleft()
        if visited[v]:
            if d != dist[v]:
                return False
            continue
        visited[v] = True
        dist[v] = d
        for w, u in A[v]:
            que.append((d + w, u))
    return True

N, M = map(int, input().split())
A = [[] for _ in range(N)]
for _ in range(M):
    l, r, w = map(int, input().split())
    l -= 1
    r -= 1
    A[l].append((w, r))
    A[r].append((-w, l))
visited = [0] * N
dist = [0] * N
res = 'Yes'
for i in range(N):
    if visited[i]:
        continue
    f = bfs(i)
    if not f:
        res = 'No'
print(res)