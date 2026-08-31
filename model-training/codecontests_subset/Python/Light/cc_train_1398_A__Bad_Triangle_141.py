for _ in range(int(input())):
    n,a = int(input()), list(map(int, input().split()))
    if (a[0] + a[1] <= a[n-1]):
        print("1 2 {}".format(n))
    else:
        print("-1")
