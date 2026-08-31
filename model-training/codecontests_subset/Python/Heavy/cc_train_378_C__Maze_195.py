from sys import stdin
from collections import *


def arr_inp(n):
    if n == 1:
        return [int(x) for x in stdin.readline().split()]
    elif n == 2:
        return [float(x) for x in stdin.readline().split()]
    else:
        return list(stdin.readline()[:-1])


def valid(i, j):
    global n, m
    return i > -1 and i < n and j > -1 and j < m


dx, dy = [-1, 0, 1, 0], [0, 1, 0, -1]


def print_maze():
    for i in range(n):
        print(*maze[i], sep='')


def bfs_util(i, j):
    queue, visit, q2 = deque([[i, j]]), defaultdict(int, {(i, j): 1}), deque([[i, j]])

    while queue:
        # dequeue parent vertix
        s = queue.popleft()

        # enqueue child vertices
        for i in range(4):
            ni, nj = s[0] + dx[i], s[1] + dy[i]

            if valid(ni, nj) and not visit[ni, nj] and maze[ni][nj] != '#':
                queue.append([ni, nj])
                q2.append([ni, nj])
                visit[ni, nj] = 1

    for i in range(k):
        ix1, ix2 = q2.pop()
        maze[ix1][ix2] = 'X'

    print_maze()


n, m, k = arr_inp(1)
maze = [arr_inp(3) for i in range(n)]

if k == 0:
    print_maze()
else:
    for i in range(n):
        try:
            ix = maze[i].index('.')
            if ix != -1:
                bfs_util(i, ix)
                break
        except:
            continue
