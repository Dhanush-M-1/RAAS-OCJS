import sys
input = sys.stdin.readline
from collections import Counter
from itertools import accumulate
import bisect


for _ in range(int(input())):
    n, m = map(int, input().split())
    A = list(map(int, input().split()))
    B = list(map(int, input().split()))
    pre = 0
    cur = 0
    C = [(0, -1)]
    for i, a in enumerate(A):
        cur += a
        if cur > pre:
            C.append((cur, i))
            pre = cur
    maxv = C[-1][0]
    ans = [-1] * m
    if not maxv:
        print(*ans)
        continue
    for i, b in enumerate(B):
        if b <= maxv:
            idx = bisect.bisect_left(C, (b, -1))
            ans[i] = C[idx][1]
        else:
            if cur <= 0: continue
            rem = b - maxv
            k = (rem + cur - 1) // cur
            b -= k * cur
            idx = bisect.bisect_left(C, (b, -1))
            ans[i] = C[idx][1] + k * n
    print(*ans)