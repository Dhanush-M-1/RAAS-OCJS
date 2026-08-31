t = int(input())
for _ in range(t):
    s = input()
    k, n, m = map(int, input().split())
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))
    c = []
    ans = 1
    i = 0; j = 0
    while i < len(a) and j < len(b):
        if a[i] == 0:
            k += 1
            i += 1
            c.append(0)
        elif b[j] == 0:
            k += 1
            j += 1
            c.append(0)
        else:
            min_ = b[j]
            j += 1
            if a[i] < min_:
                min_ = a[i]
                j -= 1
                i += 1
            if min_ <= k:
                c.append(min_)
            else:
                ans = 0
                break
    while j != len(b):
        c.append(b[j])
        if b[j] == 0:
            k += 1
        elif b[j] > k:
            ans = 0
        j += 1
    while i != len(a):
        c.append(a[i])
        if a[i] == 0:
            k += 1
        elif a[i] > k:
            ans = 0
        i += 1
    if ans:
        print(*c)
    else:
        print(-1)