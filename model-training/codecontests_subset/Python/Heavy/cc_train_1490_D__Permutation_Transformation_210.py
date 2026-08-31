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


def rec(i,j,level):
    if i>j:
        return
    if i==j:
        d[i+1]=level
        return

    x=A.index(max(A[i:j+1]))
    # print(i,j,x)
    if not i<=x<=j:
        return
    d[x+1]=level
    rec(i,x-1,level+1)
    rec(x+1,j,level+1)

for _ in range(L()[0]):
    n=L()[0]
    A=L()
    d=[0 for i in range(n+1)]
    rec(0,n-1,0)
    print(*d[1:])





    



endtime = time.time()
# print(f"Runtime of the program is {endtime - starttime}")