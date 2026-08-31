def dist(r1, c1, r2, c2):
    if r1 - c1 == r2 - c2:
        if (r1 + c1) % 2 == 0:
            rez = r2 - r1
        else:
            rez = 0
    else:
        r2 = r2 - (r1 - 1)
        c2 = c2 - (c1 - 1)
        if (r1 + c1) % 2 == 0:
            rez = (r2 - c2) // 2
        else:
            rez = (r2 - c2 + 1) // 2
    return rez

t = int(input())
for j in range(t):
    n = int(input())
    r = list(map(int, input().split()))
    c = list(map(int, input().split()))
    d = sorted(zip(r, c))
    ans = 0
    r0, c0 = 1, 1
    for r, c in d:
        ans += dist(r0, c0, r, c)
        r0, c0 = r, c
    print(ans)
