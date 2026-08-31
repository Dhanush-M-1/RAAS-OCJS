# -*- coding: utf-8 -*-
import math, string, itertools, operator, fractions, heapq, collections, re, array, bisect, sys, functools
def solve(line):
    n = int(line)
    a = [0, 0]
    while n > 1:
        if n % 2 == 0:
            n = n // 2
            a[0] += 1
        elif n % 3 == 0:
            n = n // 3
            a[1] += 1
        else:
            return -1
    if a[0] > a[1]: return -1
    return a[1] * 2 - a[0]
    
T = int(sys.stdin.readline())
t = 0
while True:
    line = sys.stdin.readline().rstrip()
    if not line:
        break
    print(solve(line))
    t += 1
