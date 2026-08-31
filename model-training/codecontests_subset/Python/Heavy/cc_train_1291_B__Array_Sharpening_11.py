for _ in range(int(input())) :
    n = int(input())
    a = list(map(int, input().split()))
    l = [0 for i in range(n)]; r = [0 for i in range(n)]
    l[0] = r[n - 1] = 1
    for i in range(1, n) :
        if l[i - 1] == 1 and a[i] >= i :
            l[i] = 1
        else : break
    for i in range(n - 2, -1, -1) :
        if r[i + 1] == 1 and a[i] >= n - 1 - i :
            r[i] = 1
        else : break
    can = False
    for i, j in zip(l, r) :
        if i == 1 and j == 1 :
            print('Yes')
            can = True
            break
    if not can : print('No')
