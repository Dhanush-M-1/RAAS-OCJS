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
    while ai < len(a) and bi < len(b):
        if a[ai] == 0:
            seq.append(0)
            ai += 1
            run_len += 1
            continue

        if b[bi] == 0:
            seq.append(0)
            bi += 1
            run_len += 1
            continue
            
        if a[ai] > run_len and b[bi] > run_len:
            seq = []
            break
            
        if a[ai] < b[bi]:
            seq.append(a[ai])
            ai += 1
        else:
            seq.append(b[bi])
            bi += 1
    
    while ai < len(a):
        if a[ai] == 0:
            seq.append(0)
            ai += 1
            run_len += 1
        elif a[ai] > run_len:
            seq = []
            break
        else:
            seq.append(a[ai])
            ai += 1
        
    while bi < len(b):
        if b[bi] == 0:
            seq.append(0)
            bi += 1
            run_len += 1
        elif b[bi] > run_len:
            seq = []
            break
        else:
            seq.append(b[bi])
            bi += 1

    if seq:
        print(' '.join(str(x) for x in seq))
    else:
        print(-1)
        