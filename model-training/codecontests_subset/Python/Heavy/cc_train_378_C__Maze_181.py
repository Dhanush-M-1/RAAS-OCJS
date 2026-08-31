from collections import deque


dirs = ((1, 0), (0, 1), (-1, 0), (0, -1))


def valid(r, c):
    return 0 <= r < n and 0 <= c < m and grid[r][c] == '.'


def dfs(r, c, count, viewed):
    queue = deque()
    queue.append((r, c))
    viewed[r][c] = True
    count -= 1
    while len(queue) != 0 and count > 0:
        r, c = queue.popleft()
        for dr, dc in dirs:
            if valid(r + dr, c + dc) and not viewed[r + dr][c + dc]:
                viewed[r + dr][c + dc] = True
                queue.append((r + dr, c + dc))
                count -= 1
            if count == 0:
                break


n, m, k = map(int, input().split())
grid = [list(input()) for _ in range(n)]
r, c = -1, -1
empty_count = 0
for ii, i in enumerate(grid):
    for jj, j in enumerate(i):
        if j == '.':
            r, c = ii, jj
            empty_count += 1
viewed = [[False] * m for _ in range(n)]
dfs(r, c, empty_count - k, viewed)
for i in range(n):
    for j in range(m):
        if grid[i][j] == '.' and not viewed[i][j]:
            grid[i][j] = 'X'
for i in grid:
    print(''.join(i))
