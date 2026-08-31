t = int(input())

for _ in range(t):
    n = int(input())

    grid = []

    for i in range(n):
        grid.append(input())

    if grid[0][1] != grid[1][0] and grid[n-1][n-2] != grid[n-2][n-1]:
        print(2)

        if grid[0][1] != grid[n-1][n-2]:
            print(1, 2)
            print(n, n-1)
        else:
            print(1, 2)
            print(n-1, n)
    
    elif grid[0][1] != grid[1][0] and grid[n-1][n-2] == grid[n-2][n-1]:
        print(1)

        if grid[0][1] == grid[n-1][n-2]:
            print(1, 2)
        else:
            print(2, 1)
    elif grid[0][1] == grid[1][0] and grid[n-1][n-2] == grid[n-2][n-1] and grid[0][1] != grid[n-1][n-2]:
        print(0)
    elif grid[0][1] == grid[1][0] and grid[n-1][n-2] == grid[n-2][n-1] and grid[0][1] == grid[n-1][n-2]:
        print(2)
        print(1, 2)
        print(2, 1)
    elif grid[0][1] == grid[1][0] and grid[n-1][n-2] != grid[n-2][n-1] and grid[0][1] == grid[n-1][n-2]:
        print(1)
        print(n, n-1)
    elif grid[0][1] == grid[1][0] and grid[n-1][n-2] != grid[n-2][n-1] and grid[0][1] != grid[n-1][n-2]:
        print(1)
        print(n-1, n)
    