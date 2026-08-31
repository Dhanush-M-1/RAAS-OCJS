from os import path
import sys
import time
mod = int(1e9 + 7)
# import re
from math import ceil, floor, gcd, log, log2, factorial, sqrt
from collections import defaultdict, Counter, OrderedDict, deque
from itertools import combinations, accumulate,groupby,product
# from string import ascii_lowercase ,ascii_uppercase
from bisect import *
from functools import reduce
from operator import mul
def star(x): return print(' '.join(map(str, x)))
def grid(r): return [lint() for i in range(r)]
def stpr(x): return sys.stdout.write(f'{x}' + '\n')
INF = float('inf')
if (path.exists('input.txt')):
    sys.stdin = open('input.txt', 'r')
    sys.stdout = open('output.txt', 'w')
import sys
from sys import stdin, stdout
from collections import *
from math import gcd, floor, ceil
from copy import deepcopy
def st(): return list(stdin.readline().strip())
def inp(): return int(stdin.readline())
def inlt(): return list(map(int, stdin.readline().split()))
def invr():return map(int, stdin.readline().split())
def pr(n): return stdout.write(str(n) + "\n")

def solve():
    a,b,c = invr()
    a1,b1,c1 = a,b,c
    res = 0 ; res1 = 0
    while a>0 and b>1:
        res += 3
        a-=1
        b-=2
        
    while b>0 and c>1:
        res+=3
        b-=1
        c-=2
    while b1>0 and c1>1:
        res1+=3
        b1-=1
        c1-=2
    while a1>0 and b1>1:
        res1 += 3
        a1-=1
        b1-=2
    print(max(res,res1))
t = 1
t = inp()
for _ in range(t):
    solve()
