n = int(input())
pairs = [tuple(int(x) for x in input().split()) for _ in range(n)]
ps, s = pairs[0][0], 2
if len(pairs) == 1:
    print(1)
else:
    for i in range(1, n - 1):
        xc, hc = pairs[i]
        xn, hn = pairs[i + 1]
        if ps < xc - hc:
            ps = xc
            s += 1
        elif xc + hc < xn:
            ps = xc + hc
            s += 1
        else:
            ps = xc
    print(s)
