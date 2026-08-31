class Solution:
    def __init__(self, grid, n, m, k):
        self.grid = grid
        self.n = n
        self.m = m
        self.k = k
        self.neighbors = [(-1, 0), (1, 0), (0, -1), (0, 1)]
        self.visited = [[False] * m for _ in range(n)]

    def solve(self):
        free_cells = 0
        for row in range(self.n):
            for col in range(self.m):
                if self.grid[row][col] == '.':
                    free_cells += 1
                    start = row, col

        self.num2visit = free_cells - self.k
        self.bfs(*start)
        for row in range(self.n):
            for col in range(self.m):
                if not self.visited[row][col] and self.grid[row][col] == '.':
                    self.grid[row][col] = 'X'

        ans = []
        for row in self.grid:
            ans.append(''.join(row))

        return '\n'.join(ans)

    def bfs(self, row, col):
        queue = [(row, col)]
        while queue:
            x, y = queue.pop()
            if self.visited[x][y]:
                continue
            
            self.visited[x][y] = True
            self.num2visit -= 1

            new_queue = []
            for dr, dc in self.neighbors:
                r = x + dr
                c = y + dc
                if 0 <= r < self.n and 0 <= c < self.m and self.grid[r][c] == '.':
                    if not self.visited[r][c]:
                        new_queue.append((r, c))

            queue += new_queue

            if self.num2visit == 0:
                return


def main():
    n, m, k = map(int, input().split())
    grid = []
    for _ in range(n):
        grid.append(list(input()))

    sol = Solution(grid, n, m, k)
    ans = sol.solve()
    print(ans)


if __name__ == "__main__":
    main()
