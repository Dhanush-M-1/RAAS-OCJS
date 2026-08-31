for _ in range(int(input())):
    n = int(input())
    a = []
    for i in range(n):
        d = list(input())
        a.append(d)
    c = 0
    if a[0][1] == a[1][0]:
        if a[n - 1][n - 2] == a[0][1]:
            c += 1
            if a[n - 2][n - 1] == a[0][1]:
                c += 1
                print(c)
                print(n - 1, n)
                print(n, n - 1)
            else:
                print(c)
                print(n, n - 1)
        elif a[n - 2][n - 1] == a[1][0]:
            c += 1
            print(c)
            print(n - 1, n)
        else:
            print("0")
    else:
        c += 1
        if a[n - 1][n - 2] == a[n - 2][n - 1]:
            if a[n - 1][n - 2] == a[0][1]:
                print(c)
                print(1, 2)
            else:
                print(c)
                print(2, 1)
        else:
            c += 1
            if a[0][1] == a[n - 1][n - 2]:
                print(c)
                print(1, 2)
                print(n - 1, n)
            else:
                print(c)
                print(1, 2)
                print(n, n - 1)