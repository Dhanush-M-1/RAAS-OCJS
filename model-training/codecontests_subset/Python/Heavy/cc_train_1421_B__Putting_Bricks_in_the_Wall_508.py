t = int(input())
for _ in range(t):
    n = int(input())
    grid = []
    for _ in range(n):
        s = input()
        grid.append(s)

    if grid[0][1] == grid[1][0]:
        if grid[n-2][n-1] == grid[n-1][n-2]:
            if grid[0][1] == grid[n-2][n-1]:
                print(2)
                print(1, 2)
                print(2, 1)
            else:
                print(0)
        else:
            print(1)
            if grid[n-2][n-1] == grid[0][1]:
                print(n-1, n)
            else:
                print(n, n-1)
    else:
        if grid[n-2][n-1] == grid[n-1][n-2]:
            print(1)
            if grid[0][1] == grid[n-2][n-1]:
                print(1, 2)
            else:
                print(2, 1)
        else:
            print(2)
            print(1, 2)  # make (1,2) same color as (2,1)
            if grid[n-2][n-1] == grid[1][0]:
                print(n-1, n)
            else:
                print(n, n-1)
