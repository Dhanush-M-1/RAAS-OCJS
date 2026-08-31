#!/usr/bin/env python3
# set vim: fdm=marker sw=4 ts=4 et

from collections import defaultdict
from collections import deque

for _ in range(int(input())):
    n = int(input())
    r = [int(i) for i in input().split()]
    c = [int(i) for i in input().split()]

    a = [(0, 1, 1)]
    for i in range(n):
        a.append((r[i] - c[i], r[i], c[i]))
    a.sort()

    ans = 0
    for i in range(1, n + 1):
        prev_d_i, prev_r_i, prev_c_i = a[i - 1]
        d_i, r_i, c_i = a[i]

        if prev_d_i == d_i:
            if d_i % 2 == 0:
                ans += r_i - prev_r_i
        else:
            if prev_d_i % 2 == 1:
                ans += (d_i - prev_d_i + 1) // 2
            else:
                ans += (d_i - prev_d_i) // 2
    print(ans)
