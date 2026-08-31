import sys

max_int = 2147483648  # 2^31
min_int = -max_int

t = int(input())
for _t in range(t):
    n, m = map(int, sys.stdin.readline().split())
    a = map(int, sys.stdin.readline().split())
    x = map(int, sys.stdin.readline().split())
    mx = 0
    s = 0
    maxs = []
    for i, aa in enumerate(a):
        s += aa
        if s > mx:
            mx = s
            maxs.append((s, i))

    full = s


    def search(v):
        l = -1
        r = len(maxs) - 1
        while r - l > 1:
            m = (r + l) // 2
            if maxs[m][0] >= v:
                r = m
            else:
                l = m
        return maxs[r][1]


    out = []
    for xx in x:
        tmp = 0
        if not maxs:
            out.append(-1)
            continue
        elif xx > maxs[-1][0]:
            if full > 0:
                tmp = (xx - maxs[-1][0] - 1) // full + 1
                xx -= full * tmp
                tmp *= n
            else:
                out.append(-1)
                continue

        # print(tmp, xx, search(xx))
        out.append(tmp + search(xx))

    print(' '.join(map(str, out)))
