for _ in range(int(input())) :
    n = int(input())
    a = list(map(int, input().split()))
    can = False
    pos, mx = 0, 0
    l = [0 for i in range(n)]; r = [0 for i in range(n)]
    l[0] = 1; r[n - 1] = 1
    for i in range(1, n) :
        if l[i - 1] == 1 and a[i] >= i :
            l[i] = 1
    for i in range(n - 2, -1, -1) :
        if r[i + 1] == 1 and a[i] >= n - 1 - i :
            r[i] = 1

    for i, j in zip(l, r) :
        if i == 1 and j == 1 :
            can = True

    if can :
        print('Yes')
    else :
        print('No')
