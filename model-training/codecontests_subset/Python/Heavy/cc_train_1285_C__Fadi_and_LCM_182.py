import sys
import math
import heapq
import bisect
import re
from collections import deque
from decimal import *
from fractions import gcd
 
sys.setrecursionlimit(1000000000)
def input():
    return sys.stdin.readline().strip()
 
def iinput():
    return int(input())
 
def finput():
    return float(input())
 
def tinput():
    return input().split()
 
def rinput():
    return map(int, tinput())
 
def rlinput():
    return list(rinput())
 
def modst(q, s):
    res = 1
    while s:
        if s % 2:
            res *= q
        q *= q
        s //= 2
    return res

def main():
    # [int(i) for i in sys.stdin.readline().split()]
    n = int(sys.stdin.readline())
    for i in range(int(n ** 0.5) + 1, 0, -1):
        if n % i == 0 and gcd(i, n // i) == 1 or i == 1:
            r = i
            break
    print(r, n // r)
    
for i in range(1):
    main()