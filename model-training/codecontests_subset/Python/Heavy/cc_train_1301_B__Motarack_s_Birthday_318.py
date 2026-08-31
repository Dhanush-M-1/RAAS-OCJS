for _ in range(int(input())):
    n = int(input())
    a = list(map(int, input().split()))
    l = []
    for i in range(n):
        if a[i] != -1:
            if (i > 0 and a[i - 1] == -1) or (i < n - 1 and a[i + 1] == -1):
                l.append(a[i])
    s = sum(l)
    if len(l) > 0:
        avg = (max(l) + min(l)) // 2
    else:
        avg = 5
    for i in range(n):
        if a[i] == -1:
            a[i] = avg
    diff = 0
    for i in range(n - 1):
        diff = max(diff, abs(a[i + 1] - a[i]))
    print(diff, avg)