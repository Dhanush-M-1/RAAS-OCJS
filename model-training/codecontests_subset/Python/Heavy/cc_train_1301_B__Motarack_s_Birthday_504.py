t = int(input())
for _ in range(t):
    n = int(input())
    a = [int(i) for i in input().split()]
    b = []
    c = 0
    for i in range(len(a) - 1):
        if a[i] == -1 and a[i + 1] != -1:
            b.append(a[i + 1])
        elif a[i + 1] == -1 and a[i] != -1:
            b.append(a[i])
        elif a[i] != -1 and a[i + 1] != -1:
            c = max(c, abs(a[i] - a[i + 1]))
    b.sort()
    if len(b) != 0:
        ans = (b[0] + b[-1]) // 2
        mx = max(abs(b[-1] - ans), abs(b[0] - ans), c)
        print(mx, ans)
    else:
        print(0, 1)
