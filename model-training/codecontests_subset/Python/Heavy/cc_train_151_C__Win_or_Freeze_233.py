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
# sys.setrecursionlimit(int(pow(10,6)))
# sys.stdout = open("out.txt", "w")
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
    sys.stdin = open("input.txt", "r")
except:
    pass


# @lru_cache(None)
n=L()[0]
div=[]
grt=0
x=n
for i in range(2,int(n**0.5)+2):

    if n%i==0 and x!=i:
        k=0
        while(n%i==0):
            k+=1
            n//=i
        # print(i,k)
        if k>2 or (k==2 and i*i!=x):
            grt=1
            break
        div.append([i,k])
if n!=1 and n!=x:
    div.append([n,1])
if len(div)==0 or grt or len(div)>=3:
    print(1)
    if len(div)==0 and not grt:
        print(0)
    elif grt:
        print(i*i)
    else:
        print(div[0][0]*div[1][0])
    
    exit()
else:
    print(2)