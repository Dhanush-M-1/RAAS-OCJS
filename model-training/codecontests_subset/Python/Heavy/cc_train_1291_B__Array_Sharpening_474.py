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
    n = iinput()
    a = rlinput()
    flg = True
    fromright, fromleft = n, -1
    for i in range(n-1, -1, -1):
        if a[i] < n-i-1:
            break
        fromright = i
    for i in range(n):
        if a[i] < i:
            break
        fromleft = i

    if fromleft >= fromright:
        print("Yes")
    else:
        print("No")
