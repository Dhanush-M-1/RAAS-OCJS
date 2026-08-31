#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""Codeforces Round #702 (Div. 3)

Problem G. Old Floppy Drive

:author:         Kitchen Tong
:mail:    kctong529@gmail.com

Please feel free to contact me if you have any question
regarding the implementation below.
"""

__version__ = '3.0'
__date__ = '2021-03-14'


import sys
from bisect import bisect_left


def solve(n, m, a, x):
    value = 0
    accum_max = [-1]
    for i in range(n):
        value += a[i]
        accum_max.append(max(accum_max[-1], value))
    cycle_value = value

    ans = list()
    for i in range(m):
        if cycle_value <= 0 and x[i] > accum_max[-1]:
            ans.append(-1)
            continue
        if cycle_value > 0:    # it takes more than 1 cycle
            k_cycle = max((x[i] - accum_max[-1]), 0) // cycle_value
            if max((x[i] - accum_max[-1]), 0) % cycle_value > 0:
                k_cycle += 1
        else:    # it is within the first cycle
            k_cycle = 0

        x[i] -= k_cycle * cycle_value
        index = bisect_left(accum_max, x[i])
        ans.append(k_cycle * n + index - 1)
    return ans


def main(argv=None):
    t = int(input())
    for _ in range(t):
        n, m = map(int, input().split())
        a = list(map(int, input().split()))
        x = list(map(int, input().split()))
        print(' '.join(map(str, solve(n, m, a, x))))
    return 0


if __name__ == "__main__":
    STATUS = main()
    sys.exit(STATUS)
