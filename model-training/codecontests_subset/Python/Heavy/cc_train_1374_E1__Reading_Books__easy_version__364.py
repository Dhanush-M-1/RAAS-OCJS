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
# t = iinput()
oo = []
zo = []
oz = []
for _ in range(t):
    n, k = rinput()
    for i in range(n):
        t, a, b = rinput()
        if a == 1 and b == 1:
            oo.append(t)
        elif a == 1:
            oz.append(t)
        elif b==1:
            zo.append(t)
oo.sort()
zo.sort()
oz.sort()
poo = list(accumulate(oo))
pzo = list(accumulate(zo))
poz = list(accumulate(oz))
noo = len(oo)
nzo = len(zo)
noz = len(oz)
ans = float('inf')
# print(oz,zo,oo)
for i in range(noo+1):
    want = k - i
    if nzo >= want and noz >= want and want > 0 and i==0:
        # print(want)
        ans = min(ans, pzo[want - 1] + poz[want - 1])

    if nzo >= want and noz >= want and i > 0 and want > 0:
        ans = min(ans, poo[i - 1] + pzo[want - 1] + poz[want - 1])
        # print('Hello')
    if want == 0 and i==k:
        ans=min(ans,poo[i-1])

print(-1 if ans==float('inf') else ans)
