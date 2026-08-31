def solve():
    input()
    k, n, m = map(int, input().split())
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))
    res = []
    i = 0
    j = 0
    while True:
        if i < n and a[i] == 0:
            res.append(a[i])
            i += 1
            k += 1
        elif j < m and b[j] == 0:
            res.append(b[j])
            j += 1
            k += 1
            continue
        elif i < n and a[i] > 0 and a[i] <= k:
            res.append(a[i])
            i += 1
        elif j < m and b[j] > 0 and b[j] <= k:
            res.append(b[j])
            j += 1
        else:
            break
    if len(res) == n + m:
        print(*res)
    else:
        print(-1)


for i in range(int(input())):
    solve()
