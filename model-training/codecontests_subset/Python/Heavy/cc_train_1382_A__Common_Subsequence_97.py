import sys
import math
from math import factorial, inf, gcd
from heapq import *
from functools import *
from itertools import *
from collections import *
from typing import *
sys.setrecursionlimit(10**5)
#int(i) for i in input().split()
t = int(input())
for ii in range(t):
    n, m = (int(i) for i in input().split())
    a = set([int(i) for i in input().split()])
    b = set([int(i) for i in input().split()])
    f = False
    for i in a:
        if i in b:
            print('YES')
            print(1, i)
            f = True
            break
    if not f:
        print('NO')
