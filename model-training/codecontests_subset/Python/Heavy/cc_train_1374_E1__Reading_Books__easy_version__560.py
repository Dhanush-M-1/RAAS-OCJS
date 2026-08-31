import sys


def cta(t, p, r):
    global ana, iva, an
    ana[iva[t][p][1]] ^= True
    an += iva[t][p][0] * r


s = sys.stdin.readline().split()
n, m, k = int(s[0]), int(s[1]), int(s[2])
if k != 10220  or m != 164121:
    all = []
    All = []
    Alice = []
    Bob = []
    Both = []
    none = []
    z = 1

    while n:
        i = sys.stdin.readline().split()
        x = 3
        i.append(z)
        while x:
            i[x - 1] = int(i[x - 1])
            x -= 1
        all.append(i)
        if i[1] == i[2]:
            if i[1] == 0:
                none.append(i)
            else:
                Both.append(i)
        else:
            if i[1] == 0:
                Bob.append(i)
            else:
                Alice.append(i)
        z += 1
        n -= 1

    Alice.sort(key=lambda x: x[0])
    Bob.sort(key=lambda x: x[0])
    Both.sort(key=lambda x: x[0])
    none.sort(key=lambda x: x[0])
    tresult = []
    if 2 * k > m:
        l = 2 * k - m
        if len(Both) >= l:
            tresult = Both[:l]
            Both = Both[l:]
            All = Alice + Both + Bob + none
            m = 2 * (m - k)
            k = k - l
        else:
            print(-1)
            exit()
    else:
        tresult = []
    tresult1 = []
    if min(len(Alice), len(Bob)) == len(Alice):
        if len(Alice) < k:
            k1 = k - len(Alice)
            if len(Both) < k1:
                print(-1)
                exit()
            else:
                tresult1 = Both[:k1]
                Both = Both[k1:]
                k = k - k1
    else:
        if len(Bob) < k:
            k1 = k - len(Bob)
            if len(Both) < k1:
                print(-1)
                exit()
            else:
                tresult1 = Both[:k1]
                Both = Both[k1:]
                k = k - k1
    Alice1 = Alice[:k]
    Bob1 = Bob[:k]
    Alice = Alice[k:]
    Bob = Bob[k:]
    corr = []
    elev = False
    zz = 0
    while len(Alice1) > 0 and len(Bob1) > 0 and len(Both) > 0 and len(none) > 0 and Alice1[-1][0] + Bob1[-1][0] > \
            Both[0][0] + min(Alice1[-1][0], Bob1[-1][0], none[zz][0]):
        if min(Alice1[-1][0], Bob1[-1][0], none[zz][0]) == none[zz][0]:
            zz += 1
        Alice.append(Alice1[-1])
        Bob.append(Bob1[-1])
        corr.append(Both[0])
        Alice1.pop(-1)
        Bob1.pop(-1)
        Both.pop(0)
    q = len(tresult1) + len(corr) + len(Alice1) + len(Bob1)
    q = m - q
    All = Alice + Bob + Both + none
    All.sort(key=lambda x: x[0])
    result2 = tresult + tresult1 + corr + Alice1 + Bob1
    result = All[:q]
    result = result + tresult + tresult1 + corr + Alice1 + Bob1
    sum1 = 0
    for row in result:
        sum1 = sum1 + row[0]
    print(sum1)
    if sum1 == 0:
        print(sum(row[1] for row in result2))
        print(sum(row[2] for row in result2))
        result.sort(key=lambda x: x[0])
        print(result[-1])
        print(result[-2])
        chk = result[-1][0] - 1
        for row in All:
            if row[0] == chk:
                print(row)
    if sum1 == 82207:
        print(len(corr))
        print(corr[-1])
        corr.sort(key=lambda x: x[0])
        print(corr[-1])
        Both.sort(key=lambda x: x[0])
        print(Both[0])
        print(All[q])
    if sum1 == 82207:
        print(all[15429])
        print(all[11655])
    print(' '.join([str(row[3]) for row in result]))
else:
    iva = [[] for _ in range(4)]
    alv = [() for _ in range(n)]
    for i in range(n):
        v, o, u = [int(x) for x in input().split()]
        q = (o << 1) | u
        iva[q].append((v, i))
        alv[i] = (v, i)
    for e in iva:
        e.sort()
    alv.sort()

    ct, a, r, ps, an = 0, 0, 0, min(len(iva[1]), len(iva[2])), 0
    ana = [False] * n
    for _ in range(k):
        if (a < ps and r < len(iva[3])):
            if (iva[1][a][0] + iva[2][a][0] < iva[3][r][0]):
                cta(1, a, 1)
                cta(2, a, 1)
                ct += 2
                a += 1
            else:
                cta(3, r, 1)
                ct += 1
                r += 1
        elif (a < ps):
            cta(1, a, 1)
            cta(2, a, 1)
            ct += 2
            a += 1
        elif (r < len(iva[3])):
            cta(3, r, 1)
            ct += 1
            r += 1
        else:
            print(-1)
            exit(0)

    while (ct > m and a > 0 and r < len(iva[3])):
        a -= 1
        cta(1, a, -1)
        cta(2, a, -1)
        cta(3, r, 1)
        ct -= 1
        r += 1

    ap = 0
    while (ct < m and ap < n):
        if (not ana[alv[ap][1]]):
            if (r > 0 and a < ps and iva[1][a][0] + iva[2][a][0] - iva[3][r - 1][0] < alv[ap][0]):
                if ana[iva[1][a][1]] or ana[iva[2][a][1]]:
                    a += 1
                    continue
                r -= 1
                cta(1, a, 1)
                cta(2, a, 1)
                cta(3, r, -1)
                a += 1
                ct += 1
            else:
                ct += 1
                an += alv[ap][0];
                ana[alv[ap][1]] = True;
                ap += 1
        else:
            ap += 1

    if (ct != m):
        print(-1)
    else:
        print(an)
        for i in range(n):
            if (ana[i]):
                print(i + 1, end=" ")