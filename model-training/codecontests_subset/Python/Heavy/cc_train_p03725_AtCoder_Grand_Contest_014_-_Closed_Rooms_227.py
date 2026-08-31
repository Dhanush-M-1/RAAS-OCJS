import sys
reader = (s.rstrip() for s in sys.stdin)
input = reader.__next__

h,w,k = map(int, input().split())
board = [list(input()) for i in range(h)]

for i in range(h):
    for j in range(w):
        if board[i][j] == "S":
            sx, sy = i, j

from collections import deque
dxdy = [(0,1),(1,0),(0,-1),(-1,0)]
def bfs(sx, sy):
    q = deque()
    q.append((sx, sy))
    used = [[0]*w for i in range(h)]
    ans = float("inf")
    while q:
        x,y = q.pop()
        if used[x][y]:
            continue
        used[x][y] = 1
        tmp = -(-min(x, h-1-x, y, w-1-y)//k)
        ans = min(ans, tmp+1)
        for dx, dy in dxdy:
            nx = x + dx
            ny = y + dy
            if abs(nx-sx)+abs(ny-sy)>k:
                continue
            if 0<=nx<h and 0<=ny<w and board[nx][ny] == ".":
                if nx == 0 or nx == h-1 or ny == 0 or ny == w-1:
                    return 1
                if not used[nx][ny]:
                    q.append((nx,ny))
    return ans

ans = bfs(sx, sy)
print(ans)