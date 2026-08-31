for _ in range(int(input())):
    space = input()
    k, n, m = map(int,input().split())
    mono = list(map(int,input().split()))
    poly = list(map(int,input().split()))
    i, j = 0,0
    res = []
    for x in range(m+n):
        if i < n and (mono[i] == 0 or mono[i] <= k):
            if mono[i] == 0:
                k += 1
            res.append(mono[i])
            i += 1

        elif j < m and (poly[j] == 0 or poly[j] <= k):
            if poly[j] == 0:
                k += 1
            res.append(poly[j])
            j += 1
        else:
            res = [-1]
            break

    print(*res)

