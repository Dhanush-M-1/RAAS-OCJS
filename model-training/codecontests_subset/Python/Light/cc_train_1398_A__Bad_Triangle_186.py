for _ in range(int(input())):
    n = int(input())
    a = list(map(int, input().split()))
    f = False
    s = a[0] + a[1]
    if s <= a[-1]:
        print(1, 2, n)
    else:
        print(-1)
