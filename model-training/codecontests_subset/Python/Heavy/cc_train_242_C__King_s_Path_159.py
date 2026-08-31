from sys import stdin
from collections import *

dx, dy = [-1, 0, 1, 0, 1, -1, 1, -1], [0, 1, 0, -1, 1, -1, -1, 1]


def arr_inp(n):
    return [int(x) for x in stdin.readline().split()]


def valid(x, y):
    return True if x >= 0 and x <= 1000000000 and y >= 0 and y <= 1000000000 and mem[x, y] else False


def bfs_util():
    queue, visit, ans = deque([[x0, y0, 0]]), defaultdict(int), float('inf')

    while queue:
        x, y, move = queue.popleft()

        if x == x1 and y == y1:
            ans = min(ans, move)
            continue

        for i in range(8):
            nx, ny = x + dx[i], y + dy[i]

            if valid(nx, ny) and not visit[(nx, ny)]:
                queue.append([nx, ny, move + 1])
                visit[(nx, ny)] = 1

    return ans if ans != float('inf') else -1


x0, y0, x1, y1 = arr_inp(1)
mem, n = defaultdict(int), int(input())

for i in range(n):
    r, a, b = arr_inp(1)
    for j in range(a, b + 1):
        mem[r, j] = 1

print(bfs_util())