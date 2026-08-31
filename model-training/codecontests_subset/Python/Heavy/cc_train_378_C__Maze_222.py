import sys
import math

sys.setrecursionlimit(300000)
MAXNUM = math.inf
MINNUM = -1 * math.inf


def getInt():
    return int(sys.stdin.readline().rstrip())


def getInts():
    return map(int, sys.stdin.readline().rstrip().split(" "))


def getString():
    return sys.stdin.readline().rstrip()


def printOutput(ans):
    for line in ans:
        for ele in line:
            sys.stdout.write(ele)
        sys.stdout.write("\n")


def emptySquares(g):
    total = 0
    firstEmpty = None
    for i in range(len(g)):
        for j in range(len(g[0])):
            if g[i][j] != "#":
                total += 1
                firstEmpty = (i, j)
    return total, firstEmpty


toDelete = []


def dfs(grid, visited, toSave, x, y):
    if (x, y) not in visited:
        visited[(x, y)] = True
        if toSave:
            toSave -= 1
        else:
            toDelete.append((x, y))

        for i, j in zip((-1, 1, 0, 0), (0, 0, 1, -1)):
            if (
                -1 < x + i < len(grid)
                and -1 < y + j < len(grid[0])
                and (x + i, y + j) not in visited
                and grid[x + i][y + j] != "#"
            ):
                toSave = dfs(grid, visited, toSave, x + i, y + j)
    return toSave


def iterativedfs(grid, toSave, x, y):
    stack = [(x, y)]
    visited = {}
    visited[(x,y)] = True
    toDelete = []
    while stack:
        x, y = stack.pop()

        if toSave != 0:
            toSave -= 1
        else:
            toDelete.append((x, y))

        for i, j in zip((-1, 1, 0, 0), (0, 0, 1, -1)):
            if (
                -1 < x + i < len(grid)
                and -1 < y + j < len(grid[0])
                and (x + i, y + j) not in visited
                and grid[x + i][y + j] != "#"
            ):
                stack.append((x + i, y + j))
                visited[(x+i, y+j)] = True

    return toDelete


def solve(n, m, k, grid):
    if k == 0:
        return grid
    empty, firstEmpty = emptySquares(grid)
    x, y = firstEmpty
    toDelete = iterativedfs(grid, empty - k, x, y)
    for a, b in toDelete:
        grid[a][b] = "X"
    return grid


def readinput():
    n, m, k = getInts()
    grid = []
    for _ in range(n):
        grid.append([i for i in getString()])
    printOutput(solve(n, m, k, grid))


readinput()
