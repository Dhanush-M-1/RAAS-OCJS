from collections import deque

INF = float("inf")

H, W, K = map(int, input().split())
A = [list(input()) for _ in range(H)]

Si, Sj = (0, 0)
for i, a in enumerate(A):
    if "S" in a:
        Si, Sj = (i, a.index("S"))
        A[Si][Sj] = "c"
        break

distance = INF

Q = deque([(0, Si, Sj)])
while Q:
    cnt, i, j = Q.popleft()

    distance = min(distance, i, j, H - i - 1, W - j - 1)

    if cnt >= K:
        continue

    for ni, nj in ((i + 1, j), (i, j + 1), (i - 1, j), (i, j - 1)):
        if 0 <= ni < H and 0 <= nj < W and A[ni][nj] == ".":
            A[ni][nj] = "c"
            Q.append((cnt + 1, ni, nj))

print(-(-distance // K) + 1)
