from collections import deque

H, W, K = map(int, input().split())
A = [input() for _ in range(H)]

sx, sy = 0, 0
for y in range(H) :
    flag = False
    for x in range(W) :
        if A[y][x] == 'S' :
            sx, sy = x, y
            flag = True
            break
    
    if flag :
        break


dist = [[-1] * W for _ in range(H)]
dist[sy][sx] = 0
q = deque([(sy, sx)])
while q :
    y, x = q.popleft()
    if dist[y][x] == K :
        continue
    
    for dx, dy in ((1, 0), (-1, 0), (0, 1), (0, -1)) :
        nx, ny = x + dx, y + dy
        if 0 <= nx < W and 0 <= ny < H and dist[ny][nx] == -1 and A[ny][nx] == '.' :
            dist[ny][nx] = dist[y][x] + 1
            q.append((ny, nx))

ret = float('inf')
for y in range(H) :
    for x in range(W) :
        if dist[y][x] < 0 :
            continue
        
        ret = min(ret, 1 + (min(H - y, y + 1, W - x, x + 1) - 1 + K - 1) // K)
        
print(ret)