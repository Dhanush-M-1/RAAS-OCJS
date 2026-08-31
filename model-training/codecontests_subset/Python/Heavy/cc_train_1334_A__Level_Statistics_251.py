t = int(input())
for _ in range(t):
    n = int(input())
    c = []
    for i in range(n):
        a, b = map(int, input().split())
        c.append([a, b])
    if c[0][0] < c[0][1]:
        print('NO')
    else:
        f = False
        for i in range(1, n):
            if (c[i][0] < c[i - 1][0] or c[i][1] < c[i - 1][1] or
                c[i][0] < c[i][1] or c[i][0] - c[i - 1][0] < c[i][1] - c[i - 1][1]):
                f = True
                break
        if f:
            print('NO')
        else:
            print('YES')
