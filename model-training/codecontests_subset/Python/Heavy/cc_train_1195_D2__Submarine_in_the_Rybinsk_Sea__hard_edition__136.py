
# -*- coding: utf-8 -*-
# @Date    : 2019-07-18 08:25:39
# @Author  : raj lath (oorja.halt@gmail.com)
# @Link    : link
# @Version : 1.0.0

# Thanks to proizvedenie

import sys
sys.setrecursionlimit(10**5+1)

inf     =  int(10 ** 20)
max_val =  inf
min_val = -inf

RW  = lambda : sys.stdin.readline().strip()
RI  = lambda : int(RW())
RMI = lambda : [int(x) for x in sys.stdin.readline().strip().split()]
RWI = lambda : [x for x in sys.stdin.readline().strip().split()]

MOD = 998244353
def pads(x, k):
    e , r = 1, 0
    while x > 0:
        x, m  = divmod(x, 10)
        r += e * m
        e *= [10, 100][k > 0]
        k -= 1
    return r % MOD




nb  = RI()
arr = RMI()
lcnt= [0] * 11
for i in arr:
    lcnt[len(str(i))] += 1
#print(lcnt)
r = 0
for j in range(1, 11):
    for i in range(nb):
        r = (r + lcnt[j] * (pads(arr[i], j) + 10 * pads(arr[i], j-1))) % MOD
print(r)




