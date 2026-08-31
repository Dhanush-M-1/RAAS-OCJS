from collections import deque

H, W, K = map(int,input().split())
S = []
for _ in range(H):
    S.append(list(input()))

D = [[1 for i in range(W)] for j in range(H)]

for x in range(H):
    for y in range(W):
        if S[x][y] == 'S':
            sx = x
            sy = y

D[sx][sy] = 0

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

ans = float('inf')

q = deque([[sx, sy, 0]])

while len(q) != 0:
    x, y, cnt = q.popleft()
    if cnt > K:
        break
    tmp = min(x, y , H - x - 1, W - y - 1)
    if tmp != 0:
        tmp = (tmp - 1) // K
        tmp += 2
    else:
        tmp = 1
    ans = min(ans, tmp)
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < H and 0 <= ny < W and S[nx][ny] != '#' and D[nx][ny]:
            D[nx][ny] = 0
            q.append([nx, ny, cnt + 1])

print(ans)