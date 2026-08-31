for _ in range(int(input())):
    n = int(input())
    data = []
    for i in range(n):
        data.append(input())
    # print(data)

    s1 = data[0][1]
    s2 = data[1][0]
    
    f1 = data[n - 2][n - 1]
    f2 = data[n - 1][n - 2]

    if s1 == '0' and s2 == '0':
        if f1 == '0' and f2 == '0':
            print(2)
            print(n - 1, n) # f1
            print(n, n - 1) # f2
        if f1 == '0' and f2 == '1':
            print(1)
            print(n - 1, n) # f1
        if f1 == '1' and f2 == '0':
            print(1)
            print(n, n - 1) # f2
        if f1 == '1' and f2 == '1':
            print(0)
    if s1 == '0' and s2 == '1':
        if f1 == '0' and f2 == '0':
            print(1)
            print(1, 2) # s1
        if f1 == '0' and f2 == '1':
            print(2)
            print(2, 1) # s2
            print(n - 1, n) # f1
        if f1 == '1' and f2 == '0':
            print(2)
            print(2, 1) # s2
            print(n, n - 1) # f2
        if f1 == '1' and f2 == '1':
            print(1)
            print(2, 1) # s2
    if s1 == '1' and s2 == '0':
        if f1 == '0' and f2 == '0':
            print(1)
            print(2, 1) # s2
        if f1 == '0' and f2 == '1':
            print(2)
            print(2, 1) # s2
            print(n, n - 1) # f2
        if f1 == '1' and f2 == '0':
            print(2)
            print(2, 1) # s2
            print(n - 1, n) # f1
        if f1 == '1' and f2 == '1':
            print(1)
            print(1, 2) # s1
    if s1 == '1' and s2 == '1':
        if f1 == '0' and f2 == '0':
            print(0)
        if f1 == '0' and f2 == '1':
            print(1)
            print(n, n - 1) # f2
        if f1 == '1' and f2 == '0':
            print(1)
            print(n - 1, n) # f1
        if f1 == '1' and f2 == '1':
            print(2)
            print(n - 1, n) # f1
            print(n, n - 1) # f2