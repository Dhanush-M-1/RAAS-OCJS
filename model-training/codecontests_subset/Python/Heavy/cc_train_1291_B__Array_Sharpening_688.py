from bisect import bisect_left, bisect_right
from typing import List
import collections
import bisect
import itertools
import functools
from fractions import gcd
import heapq
from math import ceil, sqrt, floor

import sys
sys.setrecursionlimit(50000)

import collections


T = int(input())
for _ in range(T):
    n = int(input())
    As = list(map(int, input().split()))

    lr = 0
    rl = 0
    for i in range(n):
        if As[i] >= i:
            lr += 1
        else:
            break
    for i in range(n-1, -1, -1):
        if As[i] >= n-1-i:
            rl += 1
        else:
            break
    if lr + rl > n:
        print("Yes")
    else:
        print("No")


