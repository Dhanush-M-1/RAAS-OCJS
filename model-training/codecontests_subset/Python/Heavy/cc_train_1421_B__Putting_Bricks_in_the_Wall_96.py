t = int(input())
for case in range(t):
    n = int(input())
    grid = [input() for row in range(n)]
    cnt = 0
    ans = []
    if grid[0][1] == grid[1][0]:
        g = 1 - int(grid[0][1])
        if int(grid[-1][-2]) != g:
            ans.append((n, n - 1))
        if int(grid[-2][-1]) != g:
            ans.append((n - 1, n))
    elif grid[-1][-2] == grid[-2][-1]:
        g = 1 - int(grid[-1][-2])
        if int(grid[0][1]) != g:
            ans.append((1, 2))
        if int(grid[1][0]) != g:
            ans.append((2, 1))
    else:
        if int(grid[0][1]) != 0:
            ans.append((1, 2))
        if int(grid[1][0]) != 0:
            ans.append((2, 1))
        if int(grid[-1][-2]) != 1:
            ans.append((n, n - 1))
        if int(grid[-2][-1]) != 1:
            ans.append((n - 1, n))
    print(len(ans))
    for item in ans:
        print(*item)
