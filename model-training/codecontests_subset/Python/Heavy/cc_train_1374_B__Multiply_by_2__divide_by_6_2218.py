import sys
from functools import lru_cache, cmp_to_key
from heapq import merge, heapify, heappop, heappush
from math import *
from collections import defaultdict as dd, deque, Counter as C
from itertools import combinations as comb, permutations as perm
from bisect import bisect_left as bl, bisect_right as br, bisect
from time import perf_counter
from fractions import Fraction
# import numpy as np
sys.setrecursionlimit(int(pow(10,6)))
# sys.stdin = open("input.txt", "r")
# sys.stdout = open("out.txt", "w")
mod = int(pow(10, 9) + 7)
mod2 = 998244353
def data(): return sys.stdin.readline().strip()
def out(*var, end="\n"): sys.stdout.write(' '.join(map(str, var))+end)
def l(): return list(sp())
def sl(): return list(ssp())
def sp(): return map(int, data().split())
def ssp(): return map(str, data().split())
def l1d(n, val=0): return [val for i in range(n)]
def l2d(n, m, val=0): return [l1d(n, val) for j in range(m)]

# @lru_cache(None)
t=1
t=int(input())
for _ in range(t):
    n=l()[0]
    if n==1:
        print(0)
    else:
        c2=c3=0
        while(n%3==0):
            c3+=1
            n//=3
        while(n%2==0):
            c2+=1
            n//=2
        if n!=1:
            print(-1)
            continue
        else:
            if c3<c2:
                print(-1)
                continue
            else:
                print(c3+(c3-c2))
                