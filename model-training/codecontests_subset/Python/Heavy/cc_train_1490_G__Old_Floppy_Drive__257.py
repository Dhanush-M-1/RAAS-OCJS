from itertools import accumulate
import bisect

def solve():
    n, m = map(int, input().split())
    a = list(map(int, input().split()))
    x = list(map(int, input().split()))

    p = list(accumulate(a))
    s = p[-1]
    max_val = max(p)
    for i in range(1, n):
        p[i] = max(p[i], p[i-1])

    res = []
    for xi in x:
        if s <= 0 and xi > max_val:
            res.append(-1)
            continue
        cnt = 0
        if xi > max_val:
            c = (xi-max_val +s-1) // s
            cnt += c * n
            xi -= c * s
        idx = bisect.bisect_left(p, xi)
        res.append(cnt + idx)
    return res


t = int(input())
for _ in range(t):
    print(*solve())