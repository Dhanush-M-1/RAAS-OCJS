t = int(input())
while t:
    t -= 1
    input()
    k, n, m = map(int, input().split())
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))
    run_len = k
    ai, bi = 0, 0
    seq = []
    while ai < len(a) or bi < len(b):
        if ai < len(a) and a[ai] == 0:
            seq.append(0)
            ai += 1
            run_len += 1
            continue

        if bi < len(b) and b[bi] == 0:
            seq.append(0)
            bi += 1
            run_len += 1
            continue

        invalid = True
        if ai < len(a) and a[ai] <= run_len:
            seq.append(a[ai])
            ai += 1
            invalid = False
        
        if bi < len(b) and b[bi] <= run_len:
            seq.append(b[bi])
            bi += 1
            invalid = False
        
        if invalid:
            seq = []
            break

    if seq:
        print(' '.join(str(x) for x in seq))
    else:
        print(-1)
