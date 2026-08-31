# coding: utf-8

from __future__ import print_function
from __future__ import unicode_literals
from __future__ import division
from __future__ import absolute_import
import math
import string
import itertools
import fractions
import heapq
import collections
import re
import array
import bisect


def pp(p):
    print(" ".join([str(i) for i in p]))

def cpath():
    if l == 2:
        ps = [i for i in range(1, n + 1) if i not in (a, b, c, d)]
        path1 = [a] + ps + [b]
        if a != c:
            path2 = path1[::-1]
        else:
            path2 = path1
    elif l == 3:
        rb = [False, False]
        if a == c:
            x, y, z = a, b, d
        elif a == d:
            x, y, z = a, b, c
            rb[1] = True
        elif b == c:
            x, y, z = b, a, d
            rb[0] = True
        else:
            x, y, z = b, a, c
            rb = [True, True]
        ps = [i for i in range(1, n + 1) if i not in (a, b, c, d)]
        path1 = [x] + ps + [z] + [y]
        if rb[0]:
            path1 = path1[::-1]
        path2 = [x] + ps + [y] + [z]
        if rb[1]:
            path2 = path2[::-1]
    else:
        path1 = [a, c] + [i for i in range(1, n + 1) if i not in (a, b, c, d)] + [d, b]
        path2 = [c, a] + [i for i in range(1, n + 1) if i not in (a, b, c, d)] + [b, d]
    pp(path1)
    pp(path2)


n, k = map(int, input().split(" "))
a, b, c, d = map(int, input().split(" "))

l = len(set([a, b, c, d]))
if k < n + l - 3:
    print(-1)
elif n == 4:
    if l <= 3:
        cpath()
    else:
        print(-1)
else:
    cpath()
