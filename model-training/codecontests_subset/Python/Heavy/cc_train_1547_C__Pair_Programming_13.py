t = int(input())

for _ in range(t):
    input()
    k, n, m = map(int, input().split())
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))

    i, j = 0, 0
    c = []
    f = 1
    while f == 1:
        f = 0
        while i < n and a[i] <= k:
            c.append(a[i])
            if a[i] == 0:
                k += 1
            i += 1
            f = 1
        while j < m and b[j] <= k:
            c.append(b[j])
            if b[j] == 0:
                k += 1
            j += 1
            f = 1

    if f == 0 and (i < n or j < m):
        print(-1)
    else:
        print(*c)
