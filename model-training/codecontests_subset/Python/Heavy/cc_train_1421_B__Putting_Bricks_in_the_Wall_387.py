t = int(input())
for i in range(t):
    n = int(input())
    r = []
    for j in range(n):
        temp = input()
        r.append(temp)
    s1, s2 = int(r[0][1]), int(r[1][0])
    f1, f2 = int(r[-1][-2]), int(r[-2][-1])
    if s1 == s2 and f1 == f2:
        if s1 != f1:
            print(0)
        else:
            print(2)
            print(1, 2)
            print(2, 1)
    elif s1 == s2 and f1 != f2:
        if s1 == f1:
            print(1)
            print(n, n - 1)
        else:
            print(1)
            print(n - 1, n)
    elif s1 != s2 and f1 == f2:
        if f1 == s1:
            print(1)
            print(1, 2)
        else:
            print(1)
            print(2, 1)
    else:
        if s1 == f1:
            print(2)
            print(1, 2)
            print(n - 1, n)
        else:
            print(2)
            print(2, 1)
            print(n - 1, n)
