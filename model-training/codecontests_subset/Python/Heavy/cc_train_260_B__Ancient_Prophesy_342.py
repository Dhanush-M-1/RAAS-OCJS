"""
    Template written to be used by Python Programmers.
    Use at your own risk!!!!
    Owned by adi0311(rating - 5 star at CodeChef and Specialist at Codeforces).
"""
import sys
from functools import lru_cache, cmp_to_key
from heapq import merge, heapify, heappop, heappush, nlargest, nsmallest, _heapify_max, _heapreplace_max
from math import ceil, floor, gcd, fabs, factorial, fmod, sqrt, inf, log
from collections import defaultdict as dd, deque, Counter as c
from itertools import combinations as comb, permutations as perm
from bisect import bisect_left as bl, bisect_right as br, bisect
# sys.setrecursionlimit(2*pow(10, 6))
# sys.stdin = open("input.txt", "r")
# sys.stdout = open("output.txt", "w")
mod = pow(10, 9) + 7
mod2 = 998244353
def data(): return sys.stdin.readline().strip()
def out(var): sys.stdout.write(str(var))
def outln(var): sys.stdout.write(str(var)+"\n")
def l(): return list(sp())
def sl(): return list(ssp())
def sp(): return map(int, data().split())
def ssp(): return map(str, data().split())
def l1d(n, val=0): return [val for i in range(n)]
def l2d(n, m, val=0): return [l1d(n, val) for j in range(m)]


dp = dd(int)
s = data()
intlist = deque()
for i in range(len(s)):
    if '0' <= s[i] <= '9':
        intlist.append(s[i])
        dash_count = 0
    else:
        intlist.clear()
        # else:
        #     intlist.popleft()
        #     intlist.popleft()
    if len(intlist) == 4:
        if i-9 >= 0:
            temp = s[i-9:i+1]
            n = 10
            if 2013 <= int(temp[n-4:]) <= 2015 and temp[2] == temp[5] == '-':
                if '0' <= temp[3] <= '9' and '0' <= temp[4] <= '9':
                    month = int(temp[3:5])
                else:
                    month = -1
                if '0' <= temp[0] <= '9' and '0' <= temp[1] <= '9':
                    day = int(temp[:2])
                else:
                    day = -1
                if 1 <= month <= 12:
                    if month in [1, 3, 5, 7, 8, 10, 12]:
                        if 1 <= day <= 31:
                            dp[temp] += 1
                    elif month == 2:
                        if 1 <= day <= 28:
                            dp[temp] += 1
                    elif month in [4, 6, 9, 11]:
                        if 1 <= day <= 30:
                            dp[temp] += 1
        intlist.popleft()
        intlist.popleft()
answer, cnt = "", 0
for i in dp.keys():
    if dp[i] > cnt:
        answer = i
        cnt = dp[i]
outln(answer)
exit()
