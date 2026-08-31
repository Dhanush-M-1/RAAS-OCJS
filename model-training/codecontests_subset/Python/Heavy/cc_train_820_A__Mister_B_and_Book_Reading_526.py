#!/usr/bin/env python3

def solve():
    c, v0, v1, a, l = get([int])
    page = 0
    days = 0
    while page < c:
        page += v0 - (0 if page == 0 else l)
        v0 += a
        if v0 > v1:
            v0 = v1
        days += 1

    return days










_testcases = """
5 5 10 5 4

1

12 4 12 4 1

3

15 1 100 0 0

15

""".strip()

# ======================= B O I L E R P L A T E ======================= #
# Practicality beats purity

import re
import sys
import math
import heapq
from heapq import heapify, heappop, heappush
import bisect
import string
from bisect import bisect_left, bisect_right
import operator
from operator import itemgetter, attrgetter
import itertools
import collections

inf = float('inf')
sys.setrecursionlimit(10000)


def tree():
    return collections.defaultdict(tree)


def cache(func):  # Decorator for memoizing a function
    cache_dict = {}

    def _cached_func(*args, _get_cache=False):
        if _get_cache:
            return cache_dict
        if args in cache_dict:
            return cache_dict[args]
        cache_dict[args] = func(*args)
        return cache_dict[args]
    return _cached_func


def equal(x, y, epsilon=1e-6):
    # https://code.google.com/codejam/kickstart/resources/faq#real-number-behavior
    if -epsilon <= x - y <= epsilon:
        return True
    if -epsilon <= x <= epsilon or -epsilon <= y <= epsilon:
        return False
    return (-epsilon <= (x - y) / x <= epsilon or -epsilon <= (x - y) / y <= epsilon)


def get(_type):  # For easy input
    if type(_type) == list:
        if len(_type) == 1:
            _type = _type[0]
            return list(map(_type, input().strip().split()))
        else:
            return [_type[i](inp) for i, inp in enumerate(input().strip().split())]
    else:
        return _type(input().strip())

if __name__ == '__main__':
    print(solve())