from collections import deque
import sys
input = sys.stdin.readline

H, W, K = map(int, input().split())
A = [input().rstrip() for _ in range(H)]
si = sj = -1
for i in range(H):
    for j in range(W):
        if A[i][j] == 'S':
            si, sj = i, j
            break
    if si != -1:
        break
# ans = (min(si, H - si - 1, sj, W - sj - 1) + K - 1) // K
queue = deque([(si, sj)])
INF = 10**18
dist = [[INF] * W for _ in range(H)]
dist[si][sj] = 0
ans = INF
while queue:
    i, j = queue.popleft()
    ans = min(ans, 1 + (min(i, H - i - 1, j, W - j - 1) + K - 1) // K)
    if dist[i][j] == K:
        continue
    for di, dj in [(1, 0), (0, 1), (-1, 0), (0, -1)]:
        ni, nj = i + di, j + dj
        if 0 <= ni < H and 0 <= nj < W and A[ni][nj] == '.' and dist[ni][nj] == INF:
            dist[ni][nj] = dist[i][j] + 1
            queue.append((ni, nj))
print(ans)

