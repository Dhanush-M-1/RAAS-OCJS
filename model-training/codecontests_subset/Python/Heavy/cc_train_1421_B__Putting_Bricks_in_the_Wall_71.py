import math
import sys,bisect
from heapq import *
from itertools import *
from collections import *
sys.setrecursionlimit(10 ** 6)
I = lambda : int(sys.stdin.readline())
neo = lambda : map(int, sys.stdin.readline().split())
Neo = lambda : list(map(int, sys.stdin.readline().split()))
for _ in range(I()):
    n = I()
    grid = [input() for i in range(n)]
    a, b, c, d = grid[0][1], grid[1][0], grid[-2][-1], grid[-1][-2]
    e,f = [],[]
    if a != '0':
        e.append((1, 2))
    if b != '0':
        e.append((2, 1))
    if c != '1':
        e.append((n-1, n))
    if d != '1':
        e.append((n, n-1))
    if c != '0':
        f.append((n-1,n))
    if d != '0':
        f.append((n, n-1))
    if a != '1':
        f.append((1,2))
    if b != '1':
        f.append((2,1))
    if len(e) < len(f):
        print(len(e))
        for i in e:
            print(*i)
    else:
        print(len(f))
        for i in f:
            print(*i)