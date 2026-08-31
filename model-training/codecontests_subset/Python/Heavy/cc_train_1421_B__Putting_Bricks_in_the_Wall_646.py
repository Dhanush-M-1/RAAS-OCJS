for _ in range(int(input())):
    n = int(input())
    mat = []
    for i in range(n):
        mat.append(input())
    res = []
    start = 0
    end = 0
    # all equal to 0 or 1
    if mat[0][1] == mat[1][0] == mat[n - 1][n - 2] == mat[n - 2][n - 1]: #2
        print(2)
        print(1, 2)
        print(2, 1)
    elif mat[0][1] == mat[1][0] == mat[n - 1][n - 2] and mat[n - 1][n - 2] != mat[n - 2][n - 1]: # 3 equal, 1 unequal
        print(1)
        print(n, n - 1)
    elif mat[0][1] == mat[1][0] == mat[n - 2][n - 1] and mat[n - 1][n - 2] != mat[n - 2][n - 1]: # 3 equal, 1 unequal
        print(1)
        print(n - 1, n)
    elif  mat[1][0] == mat[n - 1][n - 2]==mat[n - 2][n - 1] and mat[0][1]!=mat[1][0]: # 3 equal, 1 unequal
        print(1)
        print(2, 1)
    elif mat[0][1] == mat[n - 1][n - 2]==mat[n - 2][n - 1] and mat[0][1]!=mat[1][0]: # 3 equal, 1 unequal
        print(1)
        print(1, 2)
    elif mat[0][1] == mat[1][0] and mat[n - 1][n - 2] == mat[n - 2][n - 1]: # 2 in pair equal
        print(0)
    elif mat[0][1] == mat[n - 2][n - 1] and mat[1][0] == mat[n - 1][n - 2]:
        print(2)
        print(1, 2)
        print(n, n - 1)
    elif mat[0][1] == mat[n - 1][n - 2] and mat[n - 2][n - 1] == mat[1][0]:
        print(2)
        print(1, 2)
        print(n - 1, n)
