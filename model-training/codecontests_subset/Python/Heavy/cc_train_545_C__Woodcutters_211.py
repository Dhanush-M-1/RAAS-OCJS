import sys
from functools import lru_cache, cmp_to_key
from heapq import merge, heapify, heappop, heappush, nlargest, nsmallest
from math import ceil, floor, gcd, fabs, factorial, fmod, sqrt, inf, log
from collections import defaultdict as dd, deque, Counter as C
from itertools import combinations as comb, permutations as perm
from bisect import bisect_left as bl, bisect_right as br, bisect
from time import perf_counter
from fractions import Fraction
# sys.setrecursionlimit(pow(10, 6))
# sys.stdin = open("input.txt", "r")
# sys.stdout = open("output.txt", "w")
mod = pow(10, 9) + 7
mod2 = 998244353
def data(): return sys.stdin.readline().strip()
def out(*var, end="\n"): sys.stdout.write(" ".join(map(str, var))+end)
def l(): return list(sp())
def sl(): return list(ssp())
def sp(): return map(int, data().split())
def ssp(): return map(str, data().split())
def l1d(n, val=0): return [val for i in range(n)]
def l2d(n, m, val=0): return [l1d(n, val) for j in range(m)]


n = int(data())
dp = dd(lambda: dd(int))
mat = []
for i in range(n):
    mat.append(l())
if n <= 2:
    out(n)
    exit()
for i in range(n):
    if i == 0:
        dp[i]['left'] = 1
        dp[i]['not cut'] = 0
        dp[i]['right'] = 0
        if mat[0][0] + mat[0][1] < mat[1][0]:
            dp[i]['right'] = 1
        continue
    if mat[i][0]-mat[i][1] > mat[i-1][0]:
        dp[i]['left'] = max(dp[i-1]['left'], dp[i-1]['not cut']) + 1
    if mat[i][0]-mat[i][1] > mat[i-1][0]+mat[i-1][1]:
        dp[i]['left'] = max(dp[i]['left'], dp[i-1]['right']+1)
    dp[i]['not cut'] = max(dp[i-1]['not cut'], dp[i-1]['right'], dp[i-1]['left'])
    if i == n-1:
        dp[i]['right'] = max(dp[i-1]['right'], dp[i-1]['not cut'], dp[i-1]['left'])+1
        break
    if mat[i][0] + mat[i][1] < mat[i+1][0]:
        dp[i]['right'] = max(dp[i-1]['not cut'], dp[i-1]['right'], dp[i-1]['left']) + 1
out(max(dp[n-1]['right'], dp[n-1]['not cut'], dp[n-1]['left']))
