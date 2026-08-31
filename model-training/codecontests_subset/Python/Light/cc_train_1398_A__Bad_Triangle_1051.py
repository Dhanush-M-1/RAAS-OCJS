for _ in range(int(input())):
    n = int(input())
    x = list(map(int, input().split()))
    f = 0
    mx = max(x)
    h = x.index(mx)
    for i in range(n - 2):
        if i != h and i + 1 != h and x[i] + x[i + 1] <= mx:
            print(i + 1, i + 2, h + 1)
            f = 1
            break
    if not f:
        print(-1)
