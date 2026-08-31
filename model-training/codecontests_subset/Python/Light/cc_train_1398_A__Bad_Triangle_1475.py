for _ in range(int(input())):
    t = 1
    n = int(input())
    a = list(map(int, input().split()))



    for k in range(2, n):
        if (a[k] >= a[0] + a[1]) and t:
            t = 0
            print(1, 2, k + 1)
            break

    if t:
        print(-1)