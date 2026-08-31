for _ in range(int(input())):
    n, m = map(int, input().split())
    a = [int(i) for i in input().split()]
    b = [int(i) for i in input().split()]
    state = 0
    for el in a:
        if el in b:
            print('YES')
            print(1, el)
            state = 1
        if state == 1:
            break
    if state == 0:
        print('NO')
    # a.sort()
    # b.sort()
    # if a[-1] in b:
    #     print('YES')
    #     print(1, a[-1])
    # elif a[0] in b:
    #     print('YES')
    #     print(1, a[0])
    # elif b[-1] in a:
    #     print('YES')
    #     print(1, b[-1])
    # elif b[0] in a:
    #     print('YES')
    #     print(1, b[0])
    # else:
    #     print('NO')
