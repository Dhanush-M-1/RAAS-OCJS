for _ in range(int(input())):
    n = int(input())
    grid = []
    for i in range(n):
        grid.append(input())
    
    s_bottom, s_right, f_left, f_top = grid[1][0], grid[0][1], grid[n - 1][n - 2], grid[n - 2][n - 1]
    if s_bottom == s_right == f_left == f_top:
        print(2)
        print(1, 2)
        print(2, 1)
    elif s_bottom == s_right == f_left:
        print(1)
        print(n, n - 1)
    elif s_bottom == s_right == f_top:
        print(1)
        print(n - 1, n)
    elif f_top == f_left == s_bottom:
        print(1)
        print(2, 1)
    elif f_top == f_left == s_right:
        print(1)
        print(1, 2)
    elif f_top == s_right and f_left == s_bottom:
        print(2)
        print(n - 1, n)
        print(2, 1)
    elif f_top == s_bottom and f_left == s_right:
        print(2)
        print(n - 1, n)
        print(1, 2)
    else:
        print(0)

    