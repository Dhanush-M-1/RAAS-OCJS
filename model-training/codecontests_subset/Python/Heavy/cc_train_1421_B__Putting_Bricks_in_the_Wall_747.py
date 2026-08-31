t = int(input())
while t:
    t += -1
    n = int(input())
    l = []
    for i in range(n):
        tmp = list(input())
        l.append(tmp)
    if l[n - 1][n - 2] == l[n - 2][n - 1]:
        if l[1][0] == l[0][1]:
            if l[1][0] == l[n - 1][n - 2]:
                print(2)
                print(2, 1)
                print(1, 2)
            else: print(0)
        else:
            if l[1][0] == l[n - 1][n - 2]:
                print(1)
                print(2, 1)
            else:
                print(1)
                print(1, 2)
    else:
        if l[0][1] == l[1][0]:
            if l[n - 1][n - 2] == l[0][1]:
                print(1)
                print(n, n - 1)
            else: 
                print(1)
                print(n - 1, n)
        else:
            if l[0][1] == l[n - 1][n - 2]:
                print(2)
                print(1, 2)
                print(n - 1, n)
            elif l[0][1] == l[n - 2][n - 1]:
                print(2)
                print(1, 2)
                print(n, n - 1)