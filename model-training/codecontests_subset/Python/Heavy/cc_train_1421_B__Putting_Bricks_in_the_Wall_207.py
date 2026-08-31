import io
import os

from collections import Counter, defaultdict, deque


def solve(N, grid):
    vals = [
        (x, y, int(grid[x][y]))
        for x, y in [(0, 1), (1, 0), (N - 1, N - 2), (N - 2, N - 1)]
    ]
    patterns = [[0, 0, 1, 1], [1, 1, 0, 0]]
    for pattern in patterns:
        flips = []
        for p, (x, y, z) in zip(pattern, vals):
            if p != z:
                flips.append(str(x + 1) + " " + str(y + 1))
        if len(flips) <= 2:
            return str(len(flips)) + "\n" + "\n".join(flips)
    assert False


if __name__ == "__main__":
    input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline

    TC = int(input())
    for tc in range(1, TC + 1):
        (N,) = [int(x) for x in input().split()]
        grid = [list(input().decode().rstrip()) for i in range(N)]
        ans = solve(N, grid)
        print(ans)
