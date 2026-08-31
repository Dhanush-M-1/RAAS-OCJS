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
# t=int(input())
for _ in range(t):
    n,k=l()
    A=[[],[],[]]
    bc=0
    ac=0
    for i in range(n):
        a,b,c=l()
        if b==c and b==1:
            A[0].append(a)
        elif b==1 and c==0:
            A[1].append(a)
        elif b==0 and c==1:
            A[2].append(a)
    A[0].sort()
    A[1].sort()
    A[2].sort()
    for i in range(1,len(A[0])):
        A[0][i]+=A[0][i-1]
    for i in range(1,len(A[1])):
        A[1][i]+=A[1][i-1]
    for i in range(1,len(A[2])):
        A[2][i]+=A[2][i-1]
    time=10**10
    A[0]=[0]+A[0]
    A[1]=[0]+A[1]
    A[2]=[0]+A[2]
    # print(*A)
    for cnt in range(len(A[0])):
        try:
            time=min(time,A[0][cnt]+A[1][k-cnt]+A[2][k-cnt])
            # print(cnt,time)
        except:
            continue
    if time==10**10:
        print(-1)
    else:
        print(time)



