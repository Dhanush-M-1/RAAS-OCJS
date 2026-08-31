for _ in range(int(input())):
    n = int(input())
    *a, = map(int, input().split())
    c = a.copy()
    ans, ans2 = 0, 0
    a.append(-1)
    b = [0] * n
    for i in range(n):
        if a[i] == -1:
            if i:
                if a[i - 1] + 1:
                    b[i - 1] = 1
            if n - i - 1:
                if a[i + 1] + 1:
                    b[i + 1] = 1
    b = [a[i] for i in range(n) if b[i]]
    if not b:
        print(0, 0)
        continue
    b, bb = (max(b) + min(b)) // 2, (max(b) + min(b) + 1) // 2
    for i in range(n):
        if a[i] == -1:
            a[i] = b
            c[i] = bb
    for i in range(n - 1):
        ans = max(ans, abs(a[i] - a[i + 1]))
    for i in range(n - 1):
        ans2 = max(ans2, abs(c[i] - c[i + 1]))
    if ans > ans2:
        print(ans2, bb)
    else:
        print(ans, bb)