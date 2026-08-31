from bisect import bisect_left
for t in range(int(input())):
    input()
    k, n, m = map(int, input().split())
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))
    ai, bi, res = 0, 0, []
    good = True
    while ai < len(a) and bi < len(b):
        if a[ai] == 0:
            res.append('0')
            ai+=1
            k+=1
        elif b[bi] == 0:
            res.append('0')
            bi+=1
            k+=1
        else:
            if a[ai] < b[bi]:
                if a[ai] <= k:
                    res.append(str(a[ai]))
                    ai+=1
                else:
                    good = False
                    break
            else:
                if b[bi] <= k:
                    res.append(str(b[bi]))
                    bi+=1
                else:
                    good = False
                    break

    while good and ai < len(a):
        if a[ai] == 0:
            res.append('0')
            ai+=1
            k+=1
        elif a[ai] <= k:
            res.append(str(a[ai]))
            ai+=1
        else:
            good = False
            break

    while good and bi < len(b):
        if b[bi] == 0:
            res.append('0')
            bi+=1
            k+=1
        elif b[bi] <= k:
            res.append(str(b[bi]))
            bi+=1
        else:
            good = False
            break

    if good:
        print(' '.join(res))
    else:
        print(-1)           
