t = int(input())
for _ in range(t):
    n = int(input())
    a = []
    for i in range(n):
        a += [input()]
    s1, s2, f1, f2 = a[0][1], a[1][0], a[n-1][n-2], a[n-2][n-1]
    if s1 == s2:
        if f1 != f2:
            if f1 == s1:
                print(1)
                print(n, n-1)
            elif f2 == s1:
                print(1)
                print(n-1, n)
        else:
            if f1 != s1:
                print(0)
            else:
                print(2)
                print(n, n-1)
                print(n-1, n)
    else:
        if f1 != f2:
            print(2)
            if f1 == s1:
                print(n, n-1)
                print(2, 1)
            else:
                print(n-1, n)
                print(2, 1)
        else:
            print(1)
            if f1 == s1:
                print(1, 2)
            else:
                print(2, 1)
            
