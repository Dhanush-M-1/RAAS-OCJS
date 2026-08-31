def solve():
    n = int(input())
    a = list(map(int, input().split()))

    if n == 1:
        print(1, 1)
        print(-a[0])
        print(1, 1)
        print(0)
        print(1, 1)
        print(0)
        return
    
    print(1, n-1)
    for i in range(n-1):
        if (a[i] % n == 0):
            print(0, end=' ')
            continue
        k = a[i]
        a[i] += k * (n-1)
        print(k * (n-1), end=' ')
    print()
    print(2, n)
    for i in range(1, n):
        if (a[i] % n == 0):
            print(0, end=' ')
            continue
        k = a[i]
        a[i] += k * (n-1)
        print(k * (n-1), end=' ')
    print()
    print(1, n)
    for i in range(n):
        print(-a[i], end=' ')
    print()

solve()