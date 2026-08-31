import sys,os,io
import math,bisect,operator
inf,mod = float('inf'),10**9+7
# sys.setrecursionlimit(10 ** 6)
from itertools import groupby,accumulate
from heapq import heapify,heappop,heappush
from collections import deque,Counter,defaultdict
input = iter(sys.stdin.buffer.read().decode().splitlines()).__next__
Neo = lambda : list(map(int,input().split()))
# test, = Neo()
n = int(input())
if n <= 2:
    print(n)
elif n % 2 == 1:
    print(n*(n-1)*(n-2))
elif n % 3 == 0:
    print((n-1)*(n-2)*(n-3))
else:
    print(n*(n-1)*(n-3))