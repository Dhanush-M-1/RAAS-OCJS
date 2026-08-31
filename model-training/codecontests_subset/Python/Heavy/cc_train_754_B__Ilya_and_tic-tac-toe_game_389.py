IL = lambda: list(map(int, input().split()))
IS = lambda: input().split()
I = lambda: int(input())
S = lambda: input()

def sub3(s):
    return [s[i:][:3] for i in range(len(s)-2)]

grid = [list(S()) for i in range(4)]
choices = []
for row in grid:
    choices += sub3(row)

for i in range(4):
    choices += sub3([grid[j][i] for j in range(4)])

choices += sub3(grid[0][0] + grid[1][1] + grid[2][2] + grid[3][3])
choices += sub3(grid[0][3] + grid[1][2] + grid[2][1] + grid[3][0])
choices.append(grid[0][1] + grid[1][2] + grid[2][3])
choices.append(grid[0][2] + grid[1][1] + grid[2][0])
choices.append(grid[1][0] + grid[2][1] + grid[3][2])
choices.append(grid[1][3] + grid[2][2] + grid[3][1])

choices = [sorted(c) for c in choices]
print("YES" if list(".xx") in choices else "NO")