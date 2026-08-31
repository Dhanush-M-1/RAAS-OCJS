from collections import deque

INF = float("inf")

H, W, K = map(int, input().split())
A = [list(input()) for _ in range(H)]

Si, Sj = (0, 0)
for i, a in enumerate(A):
    if "S" in a:
        Si, Sj = (i, a.index("S"))
        break

distance = INF

Q = deque([(0, Si, Sj)])
while Q:
    dist, i, j = Q.popleft()
    if dist > K:
        break

    distance = min(distance, i, j, H - i - 1, W - j - 1)

    for di, dj in ((1, 0), (0, 1), (-1, 0), (0, -1)):
        ni, nj = i + di, j + dj
        if 0 <= ni < H and 0 <= nj < W and A[ni][nj] == ".":
            A[ni][nj] = "#"
            Q.append((dist + 1, ni, nj))

print(-(-distance // K) + 1)
