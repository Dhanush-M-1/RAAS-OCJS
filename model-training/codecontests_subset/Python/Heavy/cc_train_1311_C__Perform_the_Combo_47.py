"""
    Template written to be used by Python Programmers.
    Use at your own risk!!!!
    Owned by adi0311(rating - 1989 at CodeChef and 1449 at Codeforces).
"""
import sys
import bisect
import heapq
from math import *
from collections import defaultdict as dd  # defaultdict(<datatype>) Free of KeyError.
from collections import deque  # deque(list) append(), appendleft(), pop(), popleft() - O(1)
from collections import Counter  # Counter(list)  return a dict with {key: count}
from itertools import combinations as comb
# sys.setrecursionlimit(2*pow(10, 6))
# sys.stdin = open("input.txt", "r")
# sys.stdout = open("output.txt", "w")
mod = pow(10, 9) + 7
mod2 = 998244353
def data(): return sys.stdin.readline().strip()
def out(var): sys.stdout.write(var)
def l(): return list(map(int, data().split()))
def sl(): return list(map(str, data().split()))
def sp(): return map(int, data().split())
def ssp(): return map(str, data().split())
def l1d(n, val=0): return [val for i in range(n)]
def l2d(n, m, val=0): return [[val for i in range(n)] for j in range(m)]


for _ in range(int(data())):
    n, m = sp()
    s = data()
    arr = l()
    dp = dict()
    faltu = [0 for i in range(26)]
    for i in range(len(s)):
        faltu[ord(s[i])-97] += 1
        dp[i] = tuple(faltu)
    answer = [0 for i in range(26)]
    for i in s:
        answer[ord(i)-97] += 1
    for i in arr:
        for j in range(len(dp[i-1])):
            answer[j] += dp[i-1][j]
    print(*answer)
