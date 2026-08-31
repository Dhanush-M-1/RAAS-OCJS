t = int(input())
for i in range(0, t):
    n = int(input())
    a = list(map(int, input().split()))
    b = []
    d = 0
    for j in range(0, n):
        if j != 0:
            if a[j - 1] != -1 and a[j] != -1:
                d = max(d, abs(a[j - 1] - a[j]))
        if a[j] == -1:
            if j != 0:
                if a[j - 1] != -1:
                    b.append(a[j - 1])
            if j != n - 1:
                if a[j + 1] != -1:
                    b.append(a[j + 1])
    if len(b) == 0:
        print(d, 1)
    else:
        mi = min(b)
        ma = max(b)
        if (ma - mi) % 2 == 0:
            print(max(d, (ma - mi) // 2), (ma + mi) // 2)
        else:
            print(max(d, (ma - mi) // 2 + 1), (ma + mi) // 2)
