t = int(input())
for _ in range(t):
    n = int(input())
    tab = list()
    for i in range(n):
        s = str(input())
        tab.append(s)
    if tab[0][1] == tab[1][0] and tab[0][1] == '1':
        if tab[n-1][n-2] == tab[n-2][n-1]:
            if tab[n-1][n-2] == '1':
                print(2)
                print(n-1, n)
                print(n, n-1)
            else:
                print(0)
        else:
            print(1)
            if tab[n - 1][n - 2] == '1':
                print(n, n - 1)
            else:
                print(n - 1, n)
    elif tab[0][1] == tab[1][0] and tab[0][1] == '0':
        if tab[n-1][n-2] == tab[n-2][n-1]:
            if tab[n-1][n-2] == '0':
                print(2)
                print(n-1, n)
                print(n, n-1)
            else:
                print(0)
        else:
            print(1)
            if tab[n-1][n-2] == '0':
                print(n, n-1)
            else:
                print(n-1, n)
    elif tab[0][1] != tab[1][0] and tab[0][1] == '1':
        if tab[n - 1][n - 2] == tab[n - 2][n - 1]:
            if tab[n - 1][n - 2] == '0':
                print(1)
                print(2, 1)
            else:
                print(1)
                print(1, 2)
        else:
            if tab[n - 1][n - 2] == '0':
                print(2)
                print(2, 1)
                print(n-1, n)
            else:
                print(2)
                print(2, 1)
                print(n, n-1)
    else:
        if tab[n - 1][n - 2] == tab[n - 2][n - 1]:
            if tab[n - 1][n - 2] == '1':
                print(1)
                print(2, 1)
            else:
                print(1)
                print(1, 2)
        else:
            if tab[n - 1][n - 2] == '1':
                print(2)
                print(2, 1)
                print(n-1, n)
            else:
                print(2)
                print(2, 1)
                print(n, n-1)

