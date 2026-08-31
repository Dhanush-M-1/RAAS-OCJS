
# -*- coding: utf-8 -*-
# @Date    : 2019-05-15 09:13:15
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


lens, x, y = RMI()
ins = RW()
remainder = ins[-x:]
ans = 0
for i in range(x):
  ans  += int(remainder[-1-i]) ^ (i == y)
print(ans)