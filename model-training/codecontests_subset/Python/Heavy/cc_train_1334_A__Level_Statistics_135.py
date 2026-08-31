# HEY STALKER
for _ in range(int(input())):
    n = int(input())
    l = []
    for t in range(n):
        k = list(map(int, input().split()))
        l.append(k)
    ok = 1
    p = l[0][0]
    c = l[0][1]
    if p < c:
        ok = 0
    for t in range(1, n):
        cp = l[t][0]
        cc = l[t][1]
        if cp < cc:
            ok = 0
            break
        if cp < p or cc < c:
            ok = 0
            break
        z = cc-c
        if cp-p < z:
            ok = 0
            break
        c = cc
        p = cp
    print("YES" if ok else "NO")