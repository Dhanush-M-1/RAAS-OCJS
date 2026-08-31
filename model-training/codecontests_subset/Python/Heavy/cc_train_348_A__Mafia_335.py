import os
import io
import sys
from collections import Counter, defaultdict
import math
import random
import heapq as hq
from functools import reduce, cmp_to_key
from collections import deque
import threading
import bisect

# sys.setrecursionlimit(2000000)
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


if __name__ == "__main__":
    v = iinput()
    a = rlinput()
    print(max(max(a), sum(a)//(v-1) + 1 if sum(a) %(v-1) != 0 else sum(a)//(v-1)))
