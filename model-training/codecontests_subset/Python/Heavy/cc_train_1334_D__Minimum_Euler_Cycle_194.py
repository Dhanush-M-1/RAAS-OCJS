# HEY STALKER
for _ in range(int(input())):
    n, l, r = map(int, input().split())
    z = 0
    idx = 0
    sd = (n-1)*2
    lst = (n*(n-1))+1
    while z < l:
        if sd <= 0:
            z += 1
            break
        idx += 1
        z += sd
        sd -= 2
    m = idx-1
    c = (n-1)*2
    sm = 0
    for t in range(m):
        sm += c
        c -= 2
    sm += 1
    nikal = l-sm
    p = []
    if idx == 1:
        for t in range(2, n+1):
            p.append(1)
            p.append(t)
    else:
        ii = idx
        for t in range(ii+1, n+1):
            p.append(ii)
            p.append(t)
    p.reverse()
    for tg in range(nikal):
        p.pop()
    p.reverse()
    idx += 1
    i1 = idx
    while len(p) < (r-l+1):
        if i1 == n:
            p.append(1)
        for t in range(i1+1, n+1):
            p.append(i1)
            p.append(t)
        i1 += 1
    print(*p[:(r-l+1)])