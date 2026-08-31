
# -*- coding: utf-8 -*-
# @Date    : 2019-03-31 20:19:43
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


nb_elements = RI()
elements    = RMI()
odds = []
even = []
for i in elements:
    if i % 2:
        odds.append(i)
    else:
        even.append(i)
odds = sorted(odds, reverse=True)
even = sorted(even, reverse=True)
leno = len(odds)
lene = len(even)
if leno > lene:
    print(sum(odds[lene + 1:]))
else:
    print(sum(even[leno + 1:]))