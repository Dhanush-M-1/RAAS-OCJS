t = int(input())
for _ in range(t):
    n = int(input())
    a = list(map(int, input().split()))
    x, y = a[0], a[1]
    f = False
    for i in range(2, n):
        if x + y <= a[i]:
            print(1, 2, i + 1)
            f = True
            break
    if not f:
        print(-1)