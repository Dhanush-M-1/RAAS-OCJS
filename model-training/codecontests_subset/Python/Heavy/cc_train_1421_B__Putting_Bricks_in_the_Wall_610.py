def solve():
    n = int(input())
    a = []
    for i in range(n):
        a.append(list(input()))

    s1 = int(a[0][1])
    s2 = int(a[1][0])
    f1 = int(a[n - 2][n - 1])
    f2 = int(a[n - 1][n - 2])

    c = 0
    d = []
    if s1 == s2:
        p = s1 ^ 1
        if f1 != p:
            c += 1
            d.append((n - 1, n))
        if f2 != p:
            c += 1
            d.append((n, n - 1))
    else:
        if f1 == f2:
            p = f1 ^ 1
            if s1 != p:
                c += 1
                d.append((1, 2))
            if s2 != p:
                c += 1
                d.append((2, 1))
        else:
            if s1 != 0:
                c += 1
                d.append((1, 2))
            if s2 != 0:
                c += 1
                d.append((2, 1))
            if f1 != 1:
                c += 1
                d.append((n - 1, n))
            if f2 != 1:
                c += 1
                d.append((n, n - 1))

    print(c)
    for x, y in d: print(x, y)

t = int(input())
i = 0
while i < t:
    solve()
    i += 1
