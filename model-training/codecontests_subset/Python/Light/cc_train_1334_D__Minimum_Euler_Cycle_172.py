for i in range(int(input())):
    n, l, r = map(int, input().split())
    l -= 1
    r -= 1
    c = 0
    for j in range(n):
        if (c + (n - j - 1) * 2 < l or c > r):
            c += (n - j - 1) * 2
            continue
        for k in range(j + 1, n):
            if (l <= c <= r):
                print(j + 1, end = ' ')
            c += 1
            if (l <= c <= r):
                print(k + 1, end = ' ')
            c += 1
    if (l <= c <= r):
        print(1)
    else:
        print('')