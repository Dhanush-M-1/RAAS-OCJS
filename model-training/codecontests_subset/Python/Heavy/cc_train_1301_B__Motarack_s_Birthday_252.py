import sys
for _ in range(int(input())):
    n = int(input())
    a = list(map(int, input().split()))
    x = []
    for i in range(n):
        if a[i] == -1:
            if i != 0 and a[i - 1] != -1:
                x.append(a[i - 1])
            if i != n - 1 and a[i + 1] != -1:
                x.append(a[i + 1])
    if not x:
        k1 = k2 = 0
    else:
        k1 = (max(x) + min(x)) // 2
        k2 = (max(x) + min(x) + 1) // 2
    res1 = 0
    res2 = 0
    for i in range(n - 1):
        t = a[i]
        t2 = a[i + 1]
        if t == -1:
            t = k1
        if t2 == -1:
            t2 = k1
        res1 = max(res1, abs(t - t2))
        t = a[i]
        t2 = a[i + 1]
        if t == -1:
            t = k2
        if t2 == -1:
            t2 = k2
        res2 = max(res2, abs(t - t2))
    if res1 < res2:
        print(res1, k1)
    else:
        print(res2, k2)