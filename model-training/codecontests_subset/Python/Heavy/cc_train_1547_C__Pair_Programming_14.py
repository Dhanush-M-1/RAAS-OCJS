for _ in range(int(input())):
    input()
    k, n, m = map(int, input().split())
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))


    l = []
    i = 0
    j = 0
    change = True
    while i < n and j < m:
        if b[j] <= k:
            if b[j] == 0:
                k += 1
            l.append(b[j])
            j += 1
        elif a[i] <= k:
            if a[i] == 0:
                k += 1
            l.append(a[i])
            i += 1
        else:
            change = False
            l = [-1]
            break
    if change:
        while i < n:
            if a[i] <= k:
                if a[i] == 0:
                    k += 1
                l.append(a[i])
                i += 1
            else:
                change = False
                l = [-1]
                break
        while j < m:
            if b[j] <= k:
                if b[j] == 0:
                    k += 1
                l.append(b[j])
                j += 1
            else:
                l = [-1]
                break
    print(*l)