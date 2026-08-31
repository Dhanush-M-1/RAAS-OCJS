
# -*- coding: utf-8 -*-
# @Date    : 2019-04-25 08:35:28
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
ins  = RW()
valid = False
for i in range(lens - 1):
    if ins[i] > ins[i + 1]:
        print("YES")
        print(*[i+1, i + 2])
        valid = True
        break
if not valid : print("NO")

