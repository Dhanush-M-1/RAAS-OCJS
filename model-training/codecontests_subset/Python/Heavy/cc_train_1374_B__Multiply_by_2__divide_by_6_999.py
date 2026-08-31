from fractions import Fraction
import bisect
import os
import io
from collections import Counter
import bisect
from collections import defaultdict
import math
import random
import heapq as hq
from math import sqrt
import sys
from functools import reduce, cmp_to_key
from collections import deque
import threading
from itertools import combinations
from io import BytesIO, IOBase
from itertools import accumulate
from queue import Queue


# sys.setrecursionlimit(200000)
# input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline


def input():
    return sys.stdin.readline().strip()


def iinput():
    return int(input())


def tinput():
    return input().split()


def rinput():
    return map(int, tinput())


def rlinput():
    return list(rinput())


mod = int(1e9)+7


def factors(n):
    return set(reduce(list.__add__,
                      ([i, n//i] for i in range(1, int(n**0.5) + 1) if n % i == 0)))


# ----------------------------------------------------
# sys.stdin = open('input.txt', 'r')
# sys.stdout = open('output.txt', 'w')


t = 1
t = iinput()
for _ in range(t):
    # x, y, n = rinput()
    # multi = (n // x)
    # flg=False
    # while multi > 0:
    #     ans = multi * x + y
    #     if ans <= n:
    #         flg = True
    #         print(ans)
    #         break
    #     multi-=1
    # if not flg:
    #     print(0)
    n = iinput()
    if n == 1:
        print(0)
        continue
    sixs = 0
    while n > 0 and n % 6 == 0:
        n = n // 6
        sixs += 1
    threes = 0
    while n > 0 and n % 3 == 0:
        n = n // 3
        threes += 1
    if n == 1:
        print(sixs + 2 * threes)
    else:
        print(-1)
            