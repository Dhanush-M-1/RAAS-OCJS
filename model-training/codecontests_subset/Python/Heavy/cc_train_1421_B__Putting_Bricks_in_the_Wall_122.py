for _ in range(int(input())):
    n = int(input())
    x = []
    for i in range(n):
        x.append(list(input()))
    if x[0][1] == x[1][0] and x[-1][-2] == x[-2][-1]:
        if x[0][1] != x[-1][-2]:
            print(0)
        else:
            print(2)
            print(1, 2)
            print(2, 1)
    elif x[0][1] != x[1][0]:
        if x[-1][-2] != x[-2][-1]:
            print(2)
            print(1, 2)
            if x[1][0] != x[-1][-2]:
                print(n - 1, n)
            else:
                print(n, n - 1)
        else:
            print(1)
            if x[0][1] == x[-1][-2]:
                print(1, 2)
            else:
                print(2, 1)
    else:
        if x[-1][-2] != x[-2][-1]:
            print(1)
            if x[0][1] != x[-1][-2]:
                print(n - 1, n)
            else:
                print(n, n - 1)
        else:
            print(2)
            print(1, 2)
            print(2, 1)