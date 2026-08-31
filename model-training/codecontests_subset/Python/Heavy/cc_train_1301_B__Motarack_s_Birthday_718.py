for _ in range(int(input())):
    n = int(input())
    a = list(map(int, input().split()))
    s = []
    for i in range(n):
        if i > 0 and a[i - 1] == -1 and a[i] != -1:
            s.append(a[i])
        elif i < n - 1 and a[i + 1] == -1 and a[i] != -1:
            s.append(a[i])
    s.sort()
    if len(s) == 0:
        print(0, 0)
        continue
    k = (s[0] + s[-1]) // 2
    m = -1
    for i in range(n):
        if a[i] == -1:
            a[i] = k
    for i in range(n - 1):
        m = max(abs(a[i] - a[i + 1]), m)
    print(m, k)