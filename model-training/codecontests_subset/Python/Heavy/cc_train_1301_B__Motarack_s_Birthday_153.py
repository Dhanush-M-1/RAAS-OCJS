for _ in range(int(input())):
    n = int(input())
    a = list(map(int, input().split()))
    num = 0
    s = 0
    m = 1000000010
    m1 = -1 * m
    for i in range(n):
        if a[i] == -1:
            if i - 1 >= 0:
                if a[i - 1] != -1:
                    m = min(m, a[i - 1])
                    m1 = max(m1, a[i - 1])
            if i + 1 < n:
                if a[i + 1] != -1:
                    m = min(m, a[i + 1])
                    m1 = max(m1, a[i + 1])

    k = (m + m1) // 2
    if a[0] == -1:
        a[0] = k
    ans = 0
    for i in range(1, n):
        if a[i] == -1:
            a[i] = k
        ans = max(abs(a[i] - a[i - 1]), ans)

    print(ans, k)


