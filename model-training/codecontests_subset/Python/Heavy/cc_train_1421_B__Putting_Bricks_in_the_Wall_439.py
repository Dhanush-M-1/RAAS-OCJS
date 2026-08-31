for _ in range(int(input())):
    n = int(input())
    a = []
    s = ""

    for i in range(n):
        a.append(input())
        if i == 0:
            s += a[i][1] + a[i][2]
        if i == 1:
            s += a[i][0] + a[i][1]

        if i == 2:
            s += a[i][0]

    count = 0
    x = "01011"
    y = "10100"
    xl = []
    yl = []
    for i in range(5):
        if s[i] != x[i]:
            xl.append(i)

        else:
            yl.append(i)

    if len(xl) < len(yl):
        print(len(xl))
        for i in range(len(xl)):
            if xl[i] == 0:
                print(1, 2)

            elif xl[i] == 1:
                print(1, 3)
            elif xl[i] == 2:
                print(2, 1)
            elif xl[i] == 3:
                print(2, 2)
            else:
                print(3, 1)

    else:
        print(len(yl))
        for i in range(len(yl)):
            if yl[i] == 0:
                print(1, 2)

            elif yl[i] == 1:
                print(1, 3)
            elif yl[i] == 2:
                print(2, 1)
            elif yl[i] == 3:
                print(2, 2)
            else:
                print(3, 1)
