
# -*- coding: utf-8 -*-
# @Date    : 2019-07-06 09:42:04
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
seq  = RW()
balance = 0
for i in seq:
    if i == "1":balance += 1
    else:balance -= 1
if balance != 0:
    print(1)
    print(seq)
else:
    print(2)
    print(seq[:-1], seq[-1])