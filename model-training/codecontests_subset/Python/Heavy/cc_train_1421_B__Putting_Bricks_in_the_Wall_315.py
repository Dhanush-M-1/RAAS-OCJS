t = int(input())

for case in range(t):
    n = int(input())
    grid = []
    
    for row in range(n):
        grid.append([int(q) if q in '01' else q for q in input()])

    changes = []
    q = sum([grid[0][2], grid[1][1], grid[2][0]])
    if q in (0, 3):
        if q//3 == grid[0][1]:
            changes.append([1, 2])
        if q//3 == grid[1][0]:
            changes.append([2, 1])

        print(len(changes))
        for change in changes:
            print(*change)
        
        continue

        # Otherwise, two of the cells are of one colour
        # and the other cell is of the other
        #
        # Fx1
        # y0
        # 0
        #
        # You can change (x, y) -> 1 and change 1 -> 0, as long as at least one of x,y is correct
        # If it isn't, you can change (0, 0) -> 1, 1 and solve
    assert q in (1, 2)
    majority = 0 if q == 1 else 1

    if grid[0][1] == majority and grid[1][0] == majority:
        # Floyd will now pick the majority colour. So block
        # Floyd at the opposite end
        if grid[n - 1][n - 2] == majority: changes.append([n, n-1])
        if grid[n - 2][n - 1] == majority: changes.append([n-1, n])
    else:
        if grid[0][1] == majority: changes.append([1, 2])
        if grid[1][0] == majority: changes.append([2, 1])
        if grid[0][2] != majority: changes.append([1, 3])
        if grid[1][1] != majority: changes.append([2, 2])
        if grid[2][0] != majority: changes.append([3, 1])

    assert len(changes) <= 2
    print(len(changes))
    for change in changes:
        print(*change)
