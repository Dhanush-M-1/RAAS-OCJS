def grouper(X):
    v = None
    sz = 0
    for x in X:
        if v != x:
            if not v is None:
                yield sz
            v = x
            sz = 1
        else:
            sz += 1
    if not v is None:
        yield sz


T = int(input())
for t in range(T):
    n = int(input())
    P = map(int, input().split())
    g, s, b = 0, 0, 0
    sz = 0
    for gr in grouper(P):
        sz += gr
        if sz > n // 2:
            break
        if g == 0:
            g = gr
        elif s <= g:
            s += gr
        else:
            b += gr
    ans = (0, 0, 0)
    if 0 < g < s and g < b:
        ans = (g, s, b)
    print(' '.join(map(str, ans)))
