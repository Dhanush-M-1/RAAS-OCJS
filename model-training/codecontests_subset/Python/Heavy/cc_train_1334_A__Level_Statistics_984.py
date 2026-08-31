# import math
# import random
import sys
# from bisect import bisect_left, bisect_right
# from collections import Counter, defaultdict, deque
# from functools import lru_cache, reduce
# from heapq import heapify, heappop, heappush
# from itertools import (chain, combinations, combinations_with_replacement,
#                        permutations)

MAX_INT = 2**62-1
sys.setrecursionlimit(10**7)

input = sys.stdin.readline


def read_n_int() -> list:
    return list(map(int, input().split()))


def read_int() -> int:
    return int(input())


def main():
    t = read_int()
    for _ in range(t):
        n = int(input())
        pre_p, pre_c = 0, 0
        res = False
        for _ in range(n):
            p, c = map(int, input().split())
            if not res and (p - pre_p < c - pre_c or p < pre_p or c < pre_c):
                res = True
            pre_p, pre_c = p, c
        print('YES' if not res else 'NO')


if __name__ == "__main__":
    main()
