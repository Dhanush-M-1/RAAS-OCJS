def solve():
    n = int(input())

    grid = []

    for _ in range(n):
        grid.append(input())

    g01 = grid[0][1]
    g10 = grid[1][0]
    g_12 = grid[n-1][n-2]
    g_21 = grid[n-2][n-1]

    if g01 == g10:
        if g_12 == g_21:
            if g01 == g_12:
                print("2")
                print("1 2")
                print("2 1")
            else:
                print("0")
        else:
            if g01 == "0":
                if g_12 == "0":
                    print("1")
                    print(str(n) + " " + str(n - 1))
                else:
                    print("1")
                    print(str(n - 1) + " " + str(n))
            else:
                if  g_12 == "0":
                    print("1")
                    print(str(n - 1) + " " + str(n))
                else:
                    print("1")
                    print(str(n) + " " + str(n - 1))
    else:
        if g_12 == g_21:
            if g_12 == "0":
                if g01 == "0":
                    print("1")
                    print("1 2")
                else:
                    print("1")
                    print("2 1")
            else:
                if g01 == "1":
                    print("1")
                    print("1 2")
                else:
                    print("1")
                    print("2 1")
        else:
            print("2")

            if g01 == "0":
                print("2 1")
            else:
                print("1 2")

            if g_12 == "0":
                print(str(n) + " " + str(n-1))
            else:
                print(str(n-1) + " " + str(n))


def main():
    t = int(input())

    for _ in range(t):
        solve()


main()