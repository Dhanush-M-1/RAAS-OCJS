t = int(input())
for i in range(t):
    n = int(input())
    p = 0
    c = 0
    s = 0
    for x in range(n):
        pn, cn = map(int, input().split())
        if cn > pn and s == 0:
            print('NO')
            s += 1
            continue
        if (cn < c or pn < p) and s == 0:
            print('NO')
            s += 1
            continue
        if pn == p and cn > c and s == 0:
            print('NO')
            s += 1
            continue
        if (pn - p) < (cn - c) and s == 0:
            print('NO')
            s += 1
            continue
        else:
            p = pn
            c = cn
    if s == 0:
        print('YES')