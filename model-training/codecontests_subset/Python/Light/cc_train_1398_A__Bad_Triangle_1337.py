import io
import os
import sys
from collections import deque, defaultdict
from itertools import accumulate

inf = (1 << 65)


def _input():
    x = sys.stdin.readline()
    x = x.replace('\r', '')
    x = x.replace('\n', '')
    return x


if 'STDINPUT' not in os.environ:
    input = _input
else:
    print('Standard input')


def solve():
    n = int(input())
    a = [int(x) for x in input().split()]
    x, y, c = a[0], a[1], a[-1]
    if x + y <= c:
        print(1, 2, n)
    else:
        print(-1)


test_cases = True
if test_cases:
    _q = int(input())
    for _ in range(_q):
        solve()
else:
    solve()