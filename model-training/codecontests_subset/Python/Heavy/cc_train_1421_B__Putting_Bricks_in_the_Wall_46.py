for _ in range(int(input())):
    n = int(input())
    d = {}
    for i in range(n):
        o = input()
        for j in range(n):
            x = o[j]
            d[(i+1,j+1)] = x

    if d[(1,2)] == d[(2,1)] == d[(n,n-1)] == d[(n-1,n)]:
        print(2)
        print(1,2)
        print(2,1)
        continue

    if d[(1,2)] == d[(2,1)] and d[(n,n-1)] == d[(n-1,n)]:
        print(0)
        continue

    if d[(1,2)] == d[(2,1)] == "0":
        print(1)
        if d[(n,n-1)] == "0":
            print(n,n-1)

        else:
            print(n-1,n)

        continue

    if d[(n,n-1)] == d[(n-1,n)] == "0":
        print(1)
        if d[(1,2)] == "0":
            print(1,2)

        else:
            print(2,1)

        continue

    if d[(1, 2)] == d[(2, 1)] == "1":
        print(1)
        if d[(n, n - 1)] == "1":
            print(n, n - 1)

        else:
            print(n - 1, n)

        continue

    if d[(n,n-1)] == d[(n-1,n)] == "1":
        print(1)
        if d[(1,2)] == "1":
            print(1,2)

        else:
            print(2,1)

        continue

    if d[(1,2)] == "1":
        print(2)
        print(2,1)
        if d[(n,n-1)] == "1":
            print(n,n-1)

        else:
            print(n-1,n)

        continue

    else:
        print(2)
        print(1, 2)
        if d[(n, n - 1)] == "1":
            print(n, n - 1)

        else:
            print(n - 1, n)

        continue