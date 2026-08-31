for _ in range(int(input())):
    q = input().split()
    len_a = int(q[0])
    len_b = int(q[1])
    a = input().split()
    b = input().split()
    for i in range(len_a):
        a[i] = int(a[i])
    for i in range(len_b):
        b[i] = int(b[i])
    a.sort()
    b.sort()
    flag = 0
    if len_a == 1:
        if a[0] in b:
            flag = 1
            print('YES')
            print(1, a[0])
    elif len_b== 1:
        if b[0] in a:
            flag = 1
            print('YES')
            print(1, b[0])
    elif len_a <= len_b:
        for i in range(len_a):
            if flag == 1:
                break
            d = 0
            while d < len_b - 1 and b[d] < a[i]: 
                d += 1
            if b[d] == a[i]:
                flag = 1
                print('YES')
                print(1, a[i])
    else:
        for i in range(len_b):
            if flag == 1:
                break
            d = 0
            while b[i] > a[d] and d < len_a - 1:
                d += 1
            if b[i] == a[d]:
                flag = 1
                print('YES')
                print(1, b[i])
    if flag == 0:
        print('NO')