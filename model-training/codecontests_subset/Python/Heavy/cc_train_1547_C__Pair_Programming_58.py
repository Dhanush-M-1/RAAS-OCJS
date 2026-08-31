t = int(input())

for _ in range(t):
    input()
    k, n, m = [int(x) for x in input().split()]
    a = [int(x) for x in input().split()]
    b = [int(x) for x in input().split()]
    ai = 0
    bi = 0
    change = 0
    pred_change = 0
    res = []
    while ai < n or bi < m:
        while ai < n and a[ai] <= k:
            res.append(a[ai])
            if a[ai] == 0:
                k += 1
            ai += 1
            change += 1

        while bi < m and b[bi] <= k:
            res.append(b[bi])
            if b[bi] == 0:
                k += 1
            bi += 1
            change += 1
        if change == pred_change:
            res = [-1]
            break
        pred_change = change
    for i in res:
        print(i, end=' ')
    print()
