for _ in range(int(input())):
    n = int(input())
    grid = [[*input()] for _ in range(n)]

    sr = grid[0][1]
    sd = grid[1][0]
    fu = grid[-2][-1]
    fl = grid[-1][-2]

    if (sr == sd == '0' and fu == fl == '1') or (sr == sd == '1' and fu == fl == '0'):
        print(0)
    elif sr == sd and fu != fl:
        print(1)
        if fu == sr:
            print(n - 1, n)
        else:
            print(n, n - 1)
    elif fu == fl and sr != sd:
        print(1)
        if sr == fu:
            print(1, 2)
        else:
            print(2, 1)
    elif sr == sd == fu == fl:
        print(2)
        print(1, 2)
        print(2, 1)
    elif sr != sd and fu != fl:
        print(2)
        if sr == '1':
            print(1, 2)
        else:
            print(2, 1)
        if fu == '0':
            print(n - 1, n)
        else:
            print(n, n - 1)