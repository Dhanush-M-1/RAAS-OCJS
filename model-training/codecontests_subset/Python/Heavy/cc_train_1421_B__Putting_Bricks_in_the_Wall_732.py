"""
    Author: Sagar Pandey

"""
# ---------------------------------------------------Import Libraries---------------------------------------------------
import sys
import os
from math import sqrt, log, log2, log10, gcd, floor, pow, sin, cos, tan, pi, inf, factorial
from copy import copy, deepcopy
from sys import exit, stdin, stdout
from collections import Counter, defaultdict, deque
from itertools import permutations
import heapq
from bisect import bisect_left as bl
# If the element is already present in the list,
# the left most position where element has to be inserted is returned.
from bisect import bisect_right as br
from bisect import bisect

# If the element is already present in the list,
# the right most position where element has to be inserted is r

# ---------------------------------------------------Global Variables---------------------------------------------------
# sys.setrecursionlimit(100000000)
mod = 1000000007
# ---------------------------------------------------Helper Functions---------------------------------------------------
iinp = lambda: int(sys.stdin.readline())
inp = lambda: sys.stdin.readline().strip()
strl = lambda: list(inp().strip().split(" "))
intl = lambda: list(map(int, inp().split(" ")))
mint = lambda: map(int, inp().split())
flol = lambda: list(map(float, inp().split(" ")))
flush = lambda: stdout.flush()


def permute(nums):
    def fun(arr, nums, cur, v):
        if len(cur) == len(nums):
            arr.append(cur.copy())
        i = 0
        while i < len(nums):
            if v[i]:
                i += 1
                continue
            else:
                cur.append(nums[i])
                v[i] = 1
                fun(arr, nums, cur, v)
                cur.pop()
                v[i] = 0
                i += 1
            # while i<len(nums) and nums[i]==nums[i-1]:i+=1    # Uncomment for unique permutations
        return arr

    res = []
    nums.sort()
    v = [0] * len(nums)
    return fun(res, nums, [], v)


def subsets(res, index, arr, cur):
    res.append(cur.copy())
    for i in range(index, len(arr)):
        cur.append(arr[i])
        subsets(res, i + 1, arr, cur)
        cur.pop()
    return res


def sieve(N):
    root = int(sqrt(N))
    primes = [1] * (N + 1)
    primes[0], primes[1] = 0, 0
    for i in range(2, root + 1):
        if primes[i]:
            for j in range(i * i, N + 1, i):
                primes[j] = 0
    return primes


def bs(arr, l, r, x):
    if x < arr[0] or x > arr[len(arr) - 1]:
        return -1
    while l <= r:
        mid = l + (r - l) // 2
        if arr[mid] == x:
            return mid
        elif arr[mid] < x:
            l = mid + 1
        else:
            r = mid - 1
    return -1


def isPrime(n):
    if n <= 1: return False
    if n <= 3: return True
    if n % 2 == 0 or n % 3 == 0: return False
    p = int(sqrt(n))
    for i in range(5, p + 1, 6):
        if n % i == 0 or n % (i + 2) == 0:
            return False
    return True


# -------------------------------------------------------Functions------------------------------------------------------

def solve():
    n = iinp()
    arr = []
    for i in range(n):
        a = list(input())
        arr.append(a)
    a=0
    ares=[]
    b=0
    bres=[]
    if arr[0][1]!=str(0):
        a+=1
        ares.append([1,2])
    if arr[1][0]!=str(0):
        a+=1
        ares.append([2,1])
    if arr[1][1]!=str(1):
        a+=1
        ares.append([2,2])
    if arr[2][0]!=str(1):
        a+=1
        ares.append([3,1])
    if arr[0][2]!=str(1):
        a+=1
        ares.append([1,3])

    if arr[0][1]!=str(1):
        b+=1
        bres.append([1,2])
    if arr[1][0]!=str(1):
        b+=1
        bres.append([2,1])
    if arr[1][1]!=str(0):
        b+=1
        bres.append([2,2])
    if arr[2][0]!=str(0):
        b+=1
        bres.append([3,1])
    if arr[0][2]!=str(0):
        b+=1
        bres.append([1,3])

    if a<b:
        print(a)
        for i in ares:
            print(*i)
    else:
        print(b)
        for i in bres:
            print(*i)

# -------------------------------------------------------Main Code------------------------------------------------------
for _ in range(iinp()):
    solve()
