t = int(input())

for i in range(t):
    n = list(map(int, input().split()))[0]

    l = [2, 2, 2, 2]
    cords = [
        (1, 2),
        (2, 1),
        (n - 1, n),
        (n, n - 1)
    ]

    for j in range(n):
        s = input()
        if j == 0:
            l[0] = int(s[1])
        if j == 1:
            l[1] = int(s[0])
        if j == n - 2:
            l[2] = int(s[n - 1])
        if j == n - 1:
            l[3] = int(s[n - 2])


    sum1 = l[0] + l[1]
    sum2 = l[2] + l[3]

    if sum1 == 0:
        if sum2 == 2:
            print(0)
        elif sum2 == 1:
            if l[2] == 0:
                print('1\n{} {}'.format(*cords[2]))
            else:
                print('1\n{} {}'.format(*cords[3]))
        else:
            print('2\n{} {}\n{} {}'.format(*cords[2], *cords[3]))
    elif sum1 == 2:
        if sum2 == 0:
            print(0)
        elif sum2 == 1:
            if l[2] == 0:
                print('1\n{} {}'.format(*cords[3]))
            else:
                print('1\n{} {}'.format(*cords[2]))
        else:
            print('2\n{} {}\n{} {}'.format(*cords[2], *cords[3]))
    else:
        if sum2 == 1:
            if l[0] == l[2]:
                print('2\n{} {}\n{} {}'.format(*cords[0], *cords[3]))
            else:
                print('2\n{} {}\n{} {}'.format(*cords[0], *cords[2]))
        elif sum2 == 0:
            if l[0] == 0:
                print('1\n{} {}'.format(*cords[0]))
            else:
                print('1\n{} {}'.format(*cords[1]))
        else:
            if l[0] == 1:
                print('1\n{} {}'.format(*cords[0]))
            else:
                print('1\n{} {}'.format(*cords[1]))