import sys
#import random
from bisect import bisect_right as rb
from collections import deque
#sys.setrecursionlimit(10**6)
from queue import PriorityQueue
from math import *
input_ = lambda: sys.stdin.readline().strip("\r\n")
ii = lambda : int(input_())
il = lambda : list(map(int, input_().split()))
ilf = lambda : list(map(float, input_().split()))
ip = lambda : input_()
fi = lambda : float(input_())
ap = lambda ab,bc,cd : ab[bc].append(cd)
li = lambda : list(input_())
pr = lambda x : print(x)
prinT = lambda x : print(x)
f = lambda : sys.stdout.flush()
mod = 10**9 + 7

n,m = il()
a = il()

d = [0 for i in range (m+1)]

for i in a :
    d[i] += 1

ans = 0

for i in d :
    ans += (i*(n-i))

print(ans//2)
