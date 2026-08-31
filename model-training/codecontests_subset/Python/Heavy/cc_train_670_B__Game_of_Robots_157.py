"""
Codeforces Round #334 (Div. 2)

Problem 670 B. Game of Robots

@author yamaton
@date 2015-05-05
"""

import itertools as it
import functools
import operator
import collections
import math
import sys


def solve(n, k, xs):
    ii = next(i for i in range(1, n+1) if 2 * k <= (i + 1) * (i + 2))
    p = k - ii * (ii + 1) // 2
    if p == 0:
        return xs[ii-1]
    return xs[p - 1]


def pp(*args, **kwargs):
    return print(*args, file=sys.stderr, **kwargs)


def main():
    n, k = map(int, input().strip().split())
    xs = [int(i) for i in input().strip().split()]
    assert len(xs) == n
    result = solve(n, k, xs)
    print(result)


if __name__ == '__main__':
    main()
