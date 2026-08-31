n = int(input())
for i in range(n):
    mnl, mxr = -1, -1
    m = int(input())
    mass = []
    for g in range(m):
        a, b = map(int, input().split())
        if mnl == -1 or b < mnl:
            mnl = b
        if mxr == -1 or a > mxr:
            mxr = a
        was = False
        for j in range(len(mass)):
            k = mass[j]
            if k[0] <= a <= k[1] or k[0] <= b <= k[1] or a <= k[0] <= b or a <= k[1] <= b:
                mass[j] = (max(a, k[0]), min(b, k[1]))
                was = True
                break
        if not was:
            mass.append((a, b))
    if len(mass) == 1:
        print(0)
    else:
        print(abs(mxr - mnl))
