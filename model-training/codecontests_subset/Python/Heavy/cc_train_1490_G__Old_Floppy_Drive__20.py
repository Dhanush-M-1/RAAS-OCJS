import sys
from functools import lru_cache, cmp_to_key
from heapq import merge, heapify, heappop, heappush
# from math import *
from collections import defaultdict as dd, deque, Counter as C
from itertools import combinations as comb, permutations as perm
from bisect import bisect_left as bl, bisect_right as br, bisect
from time import perf_counter
from fractions import Fraction
import copy
import time
starttime = time.time()
mod = int(pow(10, 9) + 7)
mod2 = 998244353

def data(): return sys.stdin.readline().strip()
def out(*var, end="\n"): sys.stdout.write(' '.join(map(str, var))+end)
def L(): return list(sp())
def sl(): return list(ssp())
def sp(): return map(int, data().split())
def ssp(): return map(str, data().split())
def l1d(n, val=0): return [val for i in range(n)]
def l2d(n, m, val=0): return [l1d(n, val) for j in range(m)]
try:
    # sys.setrecursionlimit(int(pow(10,6)))
    sys.stdin = open("input.txt", "r")
    # sys.stdout = open("../output.txt", "w")
except:
    pass
def pmat(A):
    for ele in A:
        print(*ele,end="\n")





from bisect import bisect_left
for i in range(int(input())):
    n, m = map(int,input().split())
    a = list(map(int,input().split()))
    p = [0]*(n+1)
    M = [0]*(n+1)
    for i in range(n):
        p[i+1] = p[i] + a[i]
        M[i+1] = max(M[i], p[i+1])
    s = p[-1]
    ans = []
    for x in map(int,input().split()):
        r = 0
        if s > 0:
            t = max((x-M[-1]+s-1)//s,0)
            r += t*n
            x -= t*s
        if x > M[-1]:
            ans.append('-1')
        else:
            pos = bisect_left(M,x)
            ans.append(str(r + pos - 1))
    print(' '.join(ans))

    




    



endtime = time.time()
# print(f"Runtime of the program is {endtime - starttime}")