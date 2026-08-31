
t = int(input())
for _ in range(t):
    n = int(input())
    brick = [[0 for _ in range(n)] for _ in range(n)]
    brick[0][0] = "S"
    brick[n-1][n-1] = "F"
    for i in range(n):
        string = input()
        for j in range(len(string)):
            if string[j] != "F" and string[j] != "S":
                brick[i][j] = int(string[j])
            else:
                brick[i][j] = string[j]

    # print(brick)
    if (brick[0][1] == 1) and (brick[1][0] == 1) and (brick[n-2][n-1] == 0) and (brick[n-1][n-2] == 0):
        print(0)
    if (brick[0][1] == 0) and (brick[1][0] == 0) and (brick[n-2][n-1] == 1) and (brick[n-1][n-2] == 1):
        print(0)

    if (brick[0][1] == 1) and (brick[1][0] == 1) and (brick[n-2][n-1] == 0) and (brick[n-1][n-2] == 1):
        print(1)
        print(n, n-1)

    if (brick[0][1] == 1) and (brick[1][0] == 1) and (brick[n - 2][n - 1] == 1) and (brick[n - 1][n - 2] == 0):
        print(1)
        print(n - 1, n)

    if (brick[0][1] == 0) and (brick[1][0] == 1) and (brick[n - 2][n - 1] == 1) and (brick[n - 1][n - 2] == 1):
        print(1)
        print(2, 1)

    if (brick[0][1] == 1) and (brick[1][0] == 0) and (brick[n - 2][n - 1] == 1) and (brick[n - 1][n - 2] == 1):
        print(1)
        print(1, 2)

    if (brick[0][1] == 0) and (brick[1][0] == 0) and (brick[n - 2][n - 1] == 0) and (brick[n - 1][n - 2] == 1):
        print(1)
        print(n-1, n)

    if (brick[0][1] == 0) and (brick[1][0] == 0) and (brick[n - 2][n - 1] == 1) and (brick[n - 1][n - 2] == 0):
        print(1)
        print(n, n-1)

    if (brick[0][1] == 1) and (brick[1][0] == 0) and (brick[n - 2][n - 1] == 0) and (brick[n - 1][n - 2] == 0):
        print(1)
        print(2, 1)

    if (brick[0][1] == 0) and (brick[1][0] == 1) and (brick[n - 2][n - 1] == 0) and (brick[n - 1][n - 2] == 0):
        print(1)
        print(1, 2)

    if (brick[0][1] == 1) and (brick[1][0] == 1) and (brick[n - 2][n - 1] == 1) and (brick[n - 1][n - 2] == 1):
        print(2)
        print(n-1, n)
        print(n, n-1)

    if (brick[0][1] == 0) and (brick[1][0] == 0) and (brick[n - 2][n - 1] == 0) and (brick[n - 1][n - 2] == 0):
        print(2)
        print(n-1, n)
        print(n, n-1)

    if (brick[0][1] == 1) and (brick[1][0] == 0) and (brick[n - 2][n - 1] == 0) and (brick[n - 1][n - 2] == 1):
        print(2)
        print(1, 2)
        print(n-1, n)

    if (brick[0][1] == 1) and (brick[1][0] == 0) and (brick[n - 2][n - 1] == 1) and (brick[n - 1][n - 2] == 0):
        print(2)
        print(1, 2)
        print(n, n-1)

    if (brick[0][1] == 0) and (brick[1][0] == 1) and (brick[n - 2][n - 1] == 0) and (brick[n - 1][n - 2] == 1):
        print(2)
        print(1, 2)
        print(n, n-1)

    if (brick[0][1] == 0) and (brick[1][0] == 1) and (brick[n - 2][n - 1] == 1) and (brick[n - 1][n - 2] == 0):
        print(2)
        print(1, 2)
        print(n-1, n)