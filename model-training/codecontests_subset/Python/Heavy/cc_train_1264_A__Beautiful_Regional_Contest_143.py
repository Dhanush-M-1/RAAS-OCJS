def solve():
    n = int(input())
    p = list(map(int, input().split()))
    g = 0
    s = 0
    b = 0
    if len(p) > 0:
        ll = p[-1]
        while len(p) > 0 and p[-1] == ll:
            p.pop()
    maxm = n // 2
    if len(p) > maxm:
        l = p[maxm]
        while len(p) > maxm or (len(p) > 0 and p[-1] == l):
            p.pop()

    gs = []

    i = 0
    c = 0
    if len(p) > 0:
        i = 1
        c = 1
    while i < len(p):
        if i < len(p):
            if p[i] == p[i - 1]:
                c += 1
                i += 1
            else:
                gs.append(c)
                if i + 1 < len(p):
                    c = 1
                else:
                    c = 1
                i += 1
        else:
            gs.append(c)
            if i + 1 < len(p):
                c = 1
            else:
                c = 0
            i += 1
    gs.append(c)
    while len(gs) > 0 and gs[-1] == 0:
        gs.pop()
    # print(p)
    # print(gs)
    # print()
    # gs = list(map(int, input().split()))
    if len(gs) < 3:
        pass
    else:
        g = gs[0]
        i = 0
        su = 0
        for i in range(1, len(gs)):
            su += gs[i]
            if su > g:
                break
        s = su
        su = 0
        for j in range(i + 1, len(gs)):
            su += gs[j]
        b = su
    if g <= 0 or s <= 0 or b <= 0 or (g >= s or g >= b):
        g = 0
        s = 0
        b = 0

    print(g, s, b)
    # print()


for _ in range(int(input())):
    solve()
