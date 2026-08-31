for _ in range(int(input())):
    a = []
    n = int(input())
    for i in range(n):
        s = input()
        if i == 0:
            a.append(int(s[1]))
        if i == 1:
            a.append(int(s[0]))
        if i == n - 2:
            a.append(int(s[n - 1]))
        if i == n - 1:
            a.append(int(s[n - 2]))
    x = sum(a)
    if a[0] == a[1] == a[2] == a[3]:
        print(2)
        print(1, 2)
        print(2, 1)
    elif (a[0] + a[1]) % 2 == 0 and (a[2] + a[3]) % 2 == 0:
        print(0)
    elif x % 2 == 1:
        print(1)
        if (a[0] == 1 and x == 1) or (a[0] == 0 and x == 3):
            print(2, 1)
        elif (a[1] == 1 and x == 1) or (a[1] == 0 and x == 3):
            print(1, 2)
        elif (a[2] == 1 and x == 1) or (a[2] == 0 and x == 3):
            print(n, n - 1)
        else:
            print(n - 1, n)
    else:
        print(2)
        if a[0] == 1:
            print(1, 2)
        else:
            print(2, 1)
        if a[2] == 0:
            print(n - 1, n)
        else:
            print(n, n - 1)
