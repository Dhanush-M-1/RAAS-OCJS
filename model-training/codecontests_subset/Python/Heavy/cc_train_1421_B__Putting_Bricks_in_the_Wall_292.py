t = int(input())
for i in range(t):
    grid = []
    n = int(input())
    for j in range(n):
        grid.append(input())
    a = grid[0][1]
    b = grid[1][0]
    c = grid[n - 2][n - 1]
    d = grid[n - 1][n - 2]
    if a == b and c == d and b == c:
        print(2)
        print("1 2")
        print("2 1")
    elif a == b and c == d:
        print(0)
    elif a == b and c != d:
        print(1)
        if a == c:
            print(str(n - 1) + " " + str(n))
        else:
            print(str(n) + " " + str(n - 1))
    elif c == d:
        print(1)
        if a == c:
            print("1 2")
        else:
            print("2 1")
    else:
        print(2)
        if a == "0":
            print("2 1")
        else:
            print("1 2")
        if c == "0":
            print(str(n - 1) + " " + str(n))
        else:
            print(str(n) + " " + str(n - 1))
