for _ in range(int(input())):
    n = int(input())
    nn = [input() for _ in range(n)]
    a = nn[0][1]
    b = nn[1][0]
    c = nn[-2][-1]
    d = nn[-1][-2]
    q = {a, b}
    w = {c, d}
    ap = 1, 2
    bp = 2, 1
    cp = n - 1, n
    dp = n, n - 1
    qw = q & w
    ans = []
    if not qw:
        pass
    elif len(q) == 1:
        q, = q
        if c == q:
            ans.append(cp)
        if d == q:
            ans.append(dp)
    elif len(w) == 1:
        q, = w
        if a == q:
            ans.append(ap)
        if b == q:
            ans.append(bp)
    else:
        if a == '0':
            ans.append(ap)
        else:
            ans.append(bp)
        if c == '1':
            ans.append(cp)
        else:
            ans.append(dp)

    print(len(ans))
    print('\n'.join(f'{a} {b}' for a, b in ans))
