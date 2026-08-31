for _ in range(int(input())):
    input()
    k, n, m = list(map(int, input().split()))
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))
    x, y = 0, 0
    z = 0
    o = []
    while x < n or y < m:
        if y == m or x < n and a[x] <= b[y]:
            o.append(a[x])
            x += 1
        else:
            o.append(b[y])
            y += 1
        if o[-1] == 0:
            k += 1
        elif o[-1] > k:
            print(-1)
            break
    else:
        print(' '.join(map(str, o)))