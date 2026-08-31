from collections import *
from itertools import *
from random import *
from bisect import *
from string import *
from queue import *
from heapq import *
from math import *
from sys import *
from re import *
def fast(): return stdin.readline().strip()
def zzz(): return [int(i) for i in fast().split()]


z, zz = input, lambda: list(map(int, z().split()))
szz, graph, mod, szzz = lambda: sorted(
    zz()), {}, 10**9 + 7, lambda: sorted(zzz())


def lcd(xnum1, xnum2): return (xnum1 * xnum2 // gcd(xnum1, xnum2))
def output(answer): stdout.write(str(answer))


dx = [-1, 1, 0, 0, 1, -1, 1, -1]
dy = [0, 0, 1, -1, 1, -1, -1, 1]


###########################---Test-Case---#################################
"""

If you Know me , Then you probably don't know me !

"""
###########################---START-CODING---##############################

num = int(z())
lst = []

for i in range(num):
    lst.append(zzz())
cnt = 1


for i in range(1, num - 1):
    curr = lst[i]
    nxt = lst[i + 1]

    if lst[i][0] - lst[i][1] > lst[i - 1][0]:
        cnt += 1
        prev = curr

    elif lst[i][0] + lst[i][1] < lst[i + 1][0]:
        cnt += 1
        lst[i][0] += lst[i][1]


print(max(1, cnt + 1 if num >= 2 else 0))
