"""
- math -
from math import factorial
from math import gcd
from math import pi
large_p = 10**9 + 7
from itertools import accumulate # 累積和
from operator import mul
- other -
from collections import Counter
from itertools import combinations
from itertools import combinations_with_replacement
from itertools import permutations
from operator import itemgetter
from functools import reduce
- list -
from copy import deepcopy
from collections import deque
from heapq import heapify, heappop, heappush
- output -
p2d = lambda x: print(*x, sep="\n")
p2line = lambda x: print(*x, sep=" ")
print(*list1, sep="\n")
- input -
import sys
read = sys.stdin.read
readline = sys.stdin.readline
readlines = sys.stdin.readlines
= map(int, input().split())
= [tuple(map(int, input().split())) for _ in range(n)]
m = map(int, read().split()) /ab = zip(m, m) /for a, b in ab:
ps = [line.split() for line in readlines()] # inputの最後まで読んでしまうので注意。
n, k, *h = map(int, read().split())
a = tuple(map(int, readlines()))
- run -
sys.setrecursionlimit(10**6)
from time import sleep
from numba import njit
"""
# ATC05

import sys
read = sys.stdin.read
readlines = sys.stdin.readlines
def main():
    n = int(input())
    o = []
    e = []
    m = map(int, read().split())
    for a in m:
        if a&1:
            o.append(a)
        else:
            e.append(a)
    sumall = sum(o) + sum(e)
    o.sort(reverse=True)
    e.sort(reverse=True)
    leno = len(o)
    lene = len(e)
    if leno == lene:
        print(0)
    elif leno < lene:
        r = sumall - sum(e[:leno+1]) - sum(o)
        print(r)
    else:
        r = sumall - sum(o[:lene+1]) - sum(e)
        print(r)


if __name__ == '__main__':
    main()
