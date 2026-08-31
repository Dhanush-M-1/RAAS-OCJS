for _ in range(int(input())):
    n = int(input())
    G = []
    for a in range(n):
        G.append(input())
    a1 = int(G[0][1])
    a2 = int(G[1][0])
    b1 = int(G[-2][-1])
    b2 = int(G[-1][-2])
    # print(a1, a2, b1, b2)

    if a1 == 0 and a2 == 0:
        if b1 == 1:
            if b2 == 1:
                print(0)
            else:
                print(1)
                print(n, n - 1)
        else:
            if b2 == 1:
                print(1)
                print(n - 1, n)
            else:
                print(2)
                print(n, n - 1)
                print(n - 1, n)
    elif b1 == 0 and b2 == 0:
        if a1 == 1:
            if a2 == 1:
                print(0)
            else:
                print(1)
                print(2, 1)
        else:
            if a2 == 1:
                print(1)
                print(1, 2)
            else:
                print(2)
                print(1, 2)
                print(2, 1)
    elif a1 == 1 and a2 == 1:
        if b1 == 0:
            if b2 == 0:
                print(0)
            else:
                print(1)
                print(n, n - 1)
        else:
            if b2 == 0:
                print(1)
                print(n - 1, n)
            else:
                print(2)
                print(n, n - 1)
                print(n - 1, n)
    elif b1 == 1 and b2 == 1:
        if a1 == 0:
            if a2 == 0:
                print(0)
            else:
                print(1)
                print(2, 1)
        else:
            if a2 == 0:
                print(1)
                print(1, 2)
            else:
                print(2)
                print(1, 2)
                print(2, 1)
    else:
        print(2)
        if a1 == 0:
            print(2, 1)
        else:
            print(1, 2)
        if b1 == 0:
            print(n - 1, n)
        else:
            print(n, n - 1)

