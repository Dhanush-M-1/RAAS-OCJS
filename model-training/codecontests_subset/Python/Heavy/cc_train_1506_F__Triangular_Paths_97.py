import sys

max_int = 2147483648  # 2^31
min_int = -max_int


def calc(r0, c0, r1, c1):
    d0 = r0 - c0
    d1 = r1 - c1

    # print(r0, c0, r1, c1, d0, d1)

    if r0 == r1 and c0 == c1:
        return 0

    if d0 == d1:
        if d0 % 2:
            return 0
        else:
            return r1 - r0

    return (d1 - d0) // 2 + (1 if d0 % 2 and not d1 % 2 else 0)


t = int(input())
for _t in range(t):
    n = int(sys.stdin.readline())
    r = list(map(int, sys.stdin.readline().split()))
    c = list(map(int, sys.stdin.readline().split()))
    l = []
    for rr, cc in zip(r, c):
        l.append((rr, cc))

    l.sort()
    prevr = 1
    prevc = 1
    out = 0
    for rr, cc in l:
        ans = calc(prevr, prevc, rr, cc)
        # print(ans)
        out += ans
        prevr = rr
        prevc = cc

    print(out)
