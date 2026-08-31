# -*- coding: utf-8 -*-
import math, string, itertools, operator, fractions, heapq, collections, re, array, bisect, sys, functools
def solve(line):
    n, k = map(int, line.split())
    a = []
    for i in range(n):
        a.append([int(x) for x in sys.stdin.readline().rstrip().split()])
    x, y, z = [], [], []
    for i in range(n):
        if a[i][1] == 1 and a[i][2] == 1:
            z.append(a[i][0])
        elif a[i][1] == 1:
            x.append(a[i][0])
        elif a[i][2] == 1:
            y.append(a[i][0])
    if len(x) + len(z) < k or len(y) + len(z) < k: return -1
    x.sort()
    y.sort()
    z.sort()
    ans = 0
    i, j, k1 = 0, 0, 0
    while k > 0:
        if i < len(x) and j < len(y) and k1 < len(z) and x[i] + y[j] < z[k1]:
            ans += x[i] + y[j]
            i += 1
            j += 1
        elif k1 < len(z):
            ans += z[k1]
            k1 += 1
        else:
            ans += x[i] + y[j]
            i += 1
            j += 1
        k -= 1
    return ans
    
t = 0
while True:
    line = sys.stdin.readline().rstrip()
    if not line:
        break
    print(solve(line))
    t += 1
