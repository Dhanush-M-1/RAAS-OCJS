n = 4

grid = []
for i in range(n):
    grid.append(list(input()))

def check_rows(grid):
    for i in range(len(grid)):
        for j in range(len(grid)-2):
            sub = grid[i][j:j+3]
            if sub.count('x') == 2 and sub.count('.') == 1:
                return True
    else:
        return False

def check_cols(grid):
    for i in range(len(grid)):
        for j in range(2):
            sub = []
            sub.append(grid[j][i])
            sub.append(grid[j+1][i])
            sub.append(grid[j+2][i])
            if sub.count('x') == 2 and sub.count('.') == 1:
                return True
    else:
        return False

def check_diag(grid):
    sub = []
    sub.append(grid[0][1])
    sub.append(grid[1][2])
    sub.append(grid[2][3])
    if sub.count('x') == 2 and sub.count('.') == 1:
        return True
    else:
        sub = []
        sub.append(grid[1][0])
        sub.append(grid[2][1])
        sub.append(grid[3][2])
        if sub.count('x') == 2 and sub.count('.') == 1:
            return True

    sub = []
    sub.append(grid[0][2])
    sub.append(grid[1][1])
    sub.append(grid[2][0])
    if sub.count('x') == 2 and sub.count('.') == 1:
        return True
    else:
        sub = []
        sub.append(grid[1][3])
        sub.append(grid[2][2])
        sub.append(grid[3][1])
        if sub.count('x') == 2 and sub.count('.') == 1:
            return True

    for i in range(len(grid)-2):
        sub = []
        sub.append(grid[i][i])
        sub.append(grid[i+1][i+1])
        sub.append(grid[i+2][i+2])
        if sub.count('x') == 2 and sub.count('.') == 1:
            return True
    else:
        for i in range(len(grid)-1,1,-1):
            for j in range(len(grid)-2):
                sub = []
                sub.append(grid[i][j])
                sub.append(grid[i-1][j+1])
                sub.append(grid[i-2][j+2])
                if sub.count('x') == 2 and sub.count('.') == 1:
                    return True
        else:
            return False

if check_rows(grid):
    print("YES")
elif check_cols(grid):
    print("YES")
elif check_diag(grid):
    print("YES")
else:
    print("NO")