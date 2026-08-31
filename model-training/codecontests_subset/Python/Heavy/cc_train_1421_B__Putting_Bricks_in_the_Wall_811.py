"""
                            pppppppppppppppppppp
                         ppppp  ppppppppppppppppppp
                      ppppppp    ppppppppppppppppppppp
                      pppppppp  pppppppppppppppppppppp
                      pppppppppppppppppppppppppppppppp
                              pppppppppppppppppppppppp
       ppppppppppppppppppppppppppppppppppppppppppppppp  pppppppppppppppppppp
      pppppppppppppppppppppppppppppppppppppppppppppppp  ppppppppppppppppppppp
     ppppppppppppppppppppppppppppppppppppppppppppppppp  pppppppppppppppppppppp
    ppppppppppppppppppppppppppppppppppppppppppppppp    pppppppppppppppppppppppp
   pppppppppppppppppppppppppppppppppppppppppppppp     pppppppppppppppppppppppppp
  ppppppppppppppppppppppppppppppppppppppppppppp      pppppppppppppppppppppppppppp
  pppppppppppppppppppppppppppppppp               pppppppppppppppppppppppppppppppp
  pppppppppppppppppppppppppppp     pppppppppppppppppppppppppppppppppppppppppppppp
  ppppppppppppppppppppppppppp    pppppppppppppppppppppppppppppppppppppppppppppppp
    pppppppppppppppppppppppp  pppppppppppppppppppppppppppppppppppppppppppppppppp
     ppppppppppppppppppppppp  ppppppppppppppppppppppppppppppppppppppppppppppppp
      pppppppppppppppppppppp  ppppppppppppppppppppppppppppppppppppppppppppppp
       ppppppppppppppppppppp  ppppppppppppppppppppppppppppppppppppppppppppp
                              pppppppppppppppppppppppp
                              pppppppppppppppppppppppppppppppp
                              pppppppppppppppppppppp  pppppppp
                              ppppppppppppppppppppp    ppppppp
                                 ppppppppppppppppppp  ppppp
                                    pppppppppppppppppppp
"""


import sys
from functools import lru_cache, cmp_to_key
from heapq import merge, heapify, heappop, heappush, nsmallest
from math import ceil, floor, gcd, fabs, factorial, fmod, sqrt, inf, log
from collections import defaultdict as dd, deque, Counter as C
from itertools import combinations as comb, permutations as perm
from bisect import bisect_left as bl, bisect_right as br, bisect
from time import perf_counter
from fractions import Fraction
from decimal import Decimal
# sys.setrecursionlimit(2 * (10 ** 5))
# sys.stdin = open("input.txt", "r")
# sys.stdout = open("output.txt", "w")
mod = pow(10, 9) + 7
mod2 = 998244353
def data(): return sys.stdin.readline().strip()
def out(var): sys.stdout.write(str(var)+"\n")
def outa(*var, end="\n"): sys.stdout.write(' '.join(map(str, var)) + end)
def l(): return list(sp())
def sl(): return list(ssp())
def sp(): return map(int, data().split())
def ssp(): return map(str, data().split())
def l1d(n, val=0): return [val for i in range(n)]
def l2d(n, m, val=0): return [l1d(n, val) for j in range(m)]


for _ in range(int(data())):
    n = int(data())
    mat = [list(data()) for i in range(n)]
    answer = []
    if mat[0][1] == mat[1][0] == mat[-1][-2] == mat[-2][-1]:
        answer.append((1, 2))
        answer.append((2, 1))
    elif mat[0][1] == mat[1][0] and mat[-1][-2] == mat[-2][-1]:
        pass
    elif mat[0][1] != mat[1][0] and mat[-1][-2] == mat[-2][-1]:
        if mat[0][1] == mat[-1][-2]:
            answer.append((1, 2))
        else:
            answer.append((2, 1))
    elif mat[0][1] == mat[1][0] and mat[-1][-2] != mat[-2][-1]:
        if mat[-1][-2] == mat[0][1]:
            answer.append((n, n-1))
        else:
            answer.append((n-1, n))
    else:
        if mat[0][1] == mat[-1][-2]:
            answer.append((1, 2))
            answer.append((n-1, n))
        else:
            answer.append((1, 2))
            answer.append((n, n-1))
    out(len(answer))
    for i in answer:
        outa(*i)
