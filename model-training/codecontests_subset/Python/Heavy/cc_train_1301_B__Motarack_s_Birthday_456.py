t = int(input())
for i in range(t):
    n = int(input())
    a = list(map(int, input().split()))
    b = []
    for j in range(n):
        if a[j] == -1:
            if j != n - 1 and a[j + 1] != -1:
                b.append(a[j + 1])
            if j != 0 and a[j - 1] != -1:
                b.append(a[j - 1])
    b.sort()
    if len(b) == 0:
        ans = 0
    elif len(b) == 1:
        ans = b[0]
    else:
        ans = (b[0] + b[-1]) // 2
    m = 0
    for j in range(1, n):
        if a[j - 1] == -1:
            a[j - 1] = ans
        if a[j] == -1:
            a[j] = ans
        m = max(m, abs(a[j] - a[j - 1]))
    print(m, ans)