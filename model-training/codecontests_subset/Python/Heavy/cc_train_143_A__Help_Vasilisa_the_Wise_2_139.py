import os,io
from sys import stdout
# import collections
# import random
# import math
# from operator import itemgetter
input = io.BytesIO(os.read(0,os.fstat(0).st_size)).readline
# from collections import Counter
# from decimal import Decimal
# import heapq
# from functools import lru_cache

# import sys
# import threading
# sys.setrecursionlimit(10**6)
# threading.stack_size(102400000)

# from functools import lru_cache
# @lru_cache(maxsize=None)

######################
# --- Maths Fns  --- #
######################
def primes(n):
    sieve = [True] * n
    for i in range(3,int(n**0.5)+1,2):
        if sieve[i]:
            sieve[i*i::2*i]=[False]*((n-i*i-1)//(2*i)+1)
    return [2] + [i for i in range(3,n,2) if sieve[i]]

def binomial_coefficient(n, k):
    if 0 <= k <= n:
        ntok = 1
        ktok = 1
        for t in range(1, min(k, n - k) + 1):
            ntok *= n
            ktok *= t
            n -= 1
        return ntok // ktok
    else:
        return 0

def powerOfK(k, max):
    if k == 1:
        return [1]
    if k == -1:
        return [-1, 1]

    result = []
    n = 1
    while n <= max:
        result.append(n)
        n *= k
    return result

def divisors(n):
    i = 1
    result = []
    while i*i <= n:
        if n%i == 0:
            if n/i == i:
                result.append(i)
            else:
                result.append(i)
                result.append(n/i)
        i+=1
    return result

# @lru_cache(maxsize=None)
def digitsSum(n):
    if n == 0:
        return 0
    r = 0
    while n > 0:
        r += n % 10
        n //= 10
    return r

######################
# ---- GRID Fns ---- #
######################
def isValid(i, j, n, m):
    return i >= 0 and i < n and j >= 0 and j < m

def print_grid(grid):
    for line in grid:
        print(" ".join(map(str,line)))

######################
# ---- MISC Fns ---- #
######################
def kadane(a,size):
    max_so_far = 0
    max_ending_here = 0

    for i in range(0, size):
        max_ending_here = max_ending_here + a[i]
        if (max_so_far < max_ending_here):
            max_so_far = max_ending_here

        if max_ending_here < 0:
            max_ending_here = 0
    return max_so_far

def prefixSum(arr):
    for i in range(1, len(arr)):
        arr[i] = arr[i] + arr[i-1]
    return arr

def ceil(n, d):
    if n % d == 0:
        return n // d
    else:
        return (n // d) + 1

# INPUTS  --------------------------
# s = input().decode('utf-8').strip()
# n = int(input())
# l = list(map(int, input().split()))
# t = int(input())
# for _ in range(t):
# for _ in range(t):

def getnumb(target):
    r = set()
    for i in range(1, (target//2)+1):
        r.add(i)
        r.add(target-i)
    return r

r1, r2 = list(map(int, input().split()))
c1, c2 = list(map(int, input().split()))
d1, d2 = list(map(int, input().split()))

c = (d2 - r1 + c1)/2
if not c.is_integer():
    print(-1)
    exit()

c = int(c)
a = int(c1 - c)
b = int(d2 - c)
d = int(r2 - c)

if a<=0 or a>=10 or b<=0 or b >=10 or c<=0 or c>=10 or d<=0 or d>=10:
    print(-1)
    exit()

s = set([a, b, c, d])
if len(s) == 4:
    if a+c==c1 and a+b==r1 and b+d==c2 and c+d==r2 and a+d==d1 and c+b==d2:
        print(a, b)
        print(c, d)
    else:
        print(-1)
else:
    print(-1)
