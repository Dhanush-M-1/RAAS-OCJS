#!usr/bin/env python3
import sys
import math
import string
import collections
import fractions
import random
from operator import itemgetter
import itertools
from collections import deque
import copy
import heapq
import bisect

MOD = 10 ** 9 + 7
INF = float('inf')
input = lambda: sys.stdin.readline().strip()

sys.setrecursionlimit(10 ** 8)

t = int(input())
for _ in range(t):
    n = int(input())
    a = list(map(int, input().split()))
    for i in range(n):
        a[i] = (a[i] + (i+1)) % n
    a.sort()
    if n == 1:
        print("YES")
    for i in range(n - 1):
        if a[i] == a[i + 1]:
            print("NO")
            break
        elif i == n - 2:
            print("YES")
