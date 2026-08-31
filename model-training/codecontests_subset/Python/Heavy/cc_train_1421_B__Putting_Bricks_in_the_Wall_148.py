import itertools
import sys
from typing import List

sys.setrecursionlimit(10 ** 9)


def lmi():
    return list(map(int, input().split()))


def main():
    for _ in range(int(input())):
        n = int(input())
        grid = [list(input()) for _ in range(n)]
        result = solve(n, grid)
        print(len(result))
        for point in result:
            print(*point)


def solve(n, grid) -> list:
    for pattern in itertools.product([False, True], repeat=4):
        if pattern[0]:
            grid[n - 1][n - 2] = reverse(grid[n - 1][n - 2])
        if pattern[1]:
            grid[n - 2][n - 1] = reverse(grid[n - 2][n - 1])
        if pattern[2]:
            grid[0][1] = reverse(grid[0][1])
        if pattern[3]:
            grid[1][0] = reverse(grid[1][0])

        ok = True
        for digit in ['0', '1']:
            stack = [(0, 0)]
            visited = set()
            while stack:
                y, x = stack.pop()
                if y < 0 or n <= y or x < 0 or n <= x:
                    continue
                if (y, x) in visited:
                    continue
                if grid[y][x] == 'F':
                    ok = False
                    break
                if grid[y][x] not in (digit, 'S'):
                    continue
                visited.add((y, x))
                for yd, xd in ((-1, 0), (+1, 0), (0, -1), (0, +1)):
                    i = y + yd
                    j = x + xd
                    stack.append((i, j))
        if ok:
            ans = []
            if pattern[0]:
                ans.append((n, n - 1))
            if pattern[1]:
                ans.append((n - 1, n))
            if pattern[2]:
                ans.append((1, 2))
            if pattern[3]:
                ans.append((2, 1))
            return ans

        if pattern[0]:
            grid[n - 1][n - 2] = reverse(grid[n - 1][n - 2])
        if pattern[1]:
            grid[n - 2][n - 1] = reverse(grid[n - 2][n - 1])
        if pattern[2]:
            grid[0][1] = reverse(grid[0][1])
        if pattern[3]:
            grid[1][0] = reverse(grid[1][0])


def reverse(digit):
    if digit == '0':
        return '1'
    else:
        return '0'


if __name__ == '__main__':
    main()
