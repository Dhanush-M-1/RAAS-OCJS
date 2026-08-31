for _ in range(int(input())):
    n = int(input())
    a = list(map(int, input().split()))
    l, h = 1000010000, -1
    for i in range(n):
        if a[i] >= 0:
            if (i and a[i - 1] < 0) or (i + 1 < n and a[i + 1] < 0):
                l = min(l, a[i])
                h = max(h, a[i])
    if l > h:
        print(0, 0)
    else:
        x = (l + h) // 2
        y = h - x
        for i in range(1, n):
            if a[i - 1] >= 0 and a[i] >= 0:
                y = max(y, abs(a[i] - a[i - 1]))
        print(y, x)
