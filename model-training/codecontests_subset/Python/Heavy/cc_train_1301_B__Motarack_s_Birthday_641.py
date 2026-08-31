# http://codeforces.com/problemset/problem/1301/B

import sys

t = int(sys.stdin.readline())
for _ in range(t):
    n = int(sys.stdin.readline())
    aq = [int(v) for v in sys.stdin.readline().split()]

    ma = -1
    mi = 2000000000
    f = False
    for i, a in enumerate(aq):
        f |= a != -1

        if i == 0:
            continue

        pa = aq[i-1]
        if a == -1 and pa != -1:
            ma = max(ma, pa)
            mi = min(mi, pa)
        elif a != -1 and pa == -1:
            ma = max(ma, a)
            mi = min(mi, a)
    k = (ma + mi) // 2

    if not f:
        print("0 0")
        continue

    mm = -1
    la = aq[0]
    if la == -1:
        la = k
    for a in aq[1:]:
        if a == -1:
            a = k
        mm = max(mm, abs(a-la))
        la = a

    print("%s %s" % (mm, k))
