
# -*- coding: utf-8 -*-
# @Date    : 2019-08-31 10:31:50
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

from collections import defaultdict
n, k = RMI()
vals = RMI()
valids = defaultdict(list)
for i in vals:
    has = 0
    while i != 0:
        valids[i].append(has)
        has += 1
        i//=2
mins = max_val
for i in valids.values():
    if len(i) >= k:
        i.sort()
        mins = min(mins, sum(i[:k]))
print(mins)

