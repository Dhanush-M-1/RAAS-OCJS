
# -*- coding: utf-8 -*-
# @Date    : 2020-01-11 07:14:43
# @Author  : raj lath (oorja.halt@gmail.com)
# @Link    : link
# @Version : 1.0.0

import sys
sys.setrecursionlimit(10**5+1)

inf     =  int(10 ** 20)
max_val =  inf
min_val = -inf

RW  = lambda : sys.stdin.readline().strip()
RI  = lambda : int(RW())
RMI = lambda : [int(x) for x in sys.stdin.readline().strip().split()]
RWI = lambda : [x for x in sys.stdin.readline().strip().split()]

from math import gcd, floor


n = RI()
limit = floor(n ** 0.5)
for i in range(limit, 0, -1):
    a, b = i, n // i
    if a * b / gcd(a, b) == n:
        print(a, b)
        break

