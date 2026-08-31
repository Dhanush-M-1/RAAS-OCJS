
# -*- coding: utf-8 -*-
# @Date    : 2020-06-16 16:38:42
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
lens = RI()
arrs = [RMI() for _ in range(lens)]
can_fell = 2

for i in range(1, lens - 1):
    if arrs[i][0] - arrs[i - 1][0] > arrs[i][1]:
        can_fell += 1
    elif arrs[i + 1][0] - arrs[i][0] > arrs[i][1]:
        arrs[i][0] += arrs[i][1]
        can_fell += 1
print(1 if len(arrs) == 1 else can_fell)





