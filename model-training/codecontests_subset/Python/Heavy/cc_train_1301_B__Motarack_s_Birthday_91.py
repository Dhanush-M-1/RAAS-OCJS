# -*- coding: utf-8 -*-
import bisect
import heapq
import math
import random
import sys
from collections import Counter, defaultdict, deque
from decimal import ROUND_CEILING, ROUND_HALF_UP, Decimal
from functools import lru_cache, reduce
from itertools import combinations, combinations_with_replacement, product, permutations
from operator import add, mul, sub

sys.setrecursionlimit(100000)
input = sys.stdin.readline  # -*- coding: utf-8 -*-

sys.setrecursionlimit(100000)
input = sys.stdin.readline
INF = 2**62-1


def read_int():
    return int(input())


def read_int_n():
    return list(map(int, input().split()))


def read_float():
    return float(input())


def read_float_n():
    return list(map(float, input().split()))


def read_str():
    return input().strip()


def read_str_n():
    return list(map(str, input().split()))


def error_print(*args):
    print(*args, file=sys.stderr)


def mt(f):
    import time

    def wrap(*args, **kwargs):
        s = time.time()
        ret = f(*args, **kwargs)
        e = time.time()

        error_print(e - s, 'sec')
        return ret

    return wrap


def slv(N, A):
    b = set()
    for i in range(N):
        if A[i] == -1:
            if i > 0 and A[i-1] != -1:
                b.add(A[i-1])
            if i < N-1 and A[i+1] != -1:
                b.add(A[i+1])
    if not b:
        return '0 0'
    d = max(b) - min(b)
    m = min(b) + d // 2
    k = 0
    for i in range(N):
        if A[i] == -1:
            A[i] = m
    for i in range(1, N):
        k = max(k, abs(A[i] - A[i-1]))
    return '%d %d' % (k, m)





def main():
    T = read_int()
    for _ in range(T):
        N = read_int()
        A = read_int_n()
        print(slv(N, A))


if __name__ == "__main__":
    main()
