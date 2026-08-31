from typing import List
import collections

import bisect
import itertools
import functools
from collections import defaultdict
import collections

from fractions import gcd
import heapq
from math import ceil, sqrt

import sys
sys.setrecursionlimit(50000)
from collections import defaultdict

t = int(input())
for _ in range(t):
    n, m = list(map(int, input().split()))

    s = input()
    p = list(map(int, input().split()))

    sub_sum = [[0] * 26 for j in range(n + 1)]
    for i, c in enumerate(s):
        for j in range(26):
            sub_sum[i+1][j] = sub_sum[i][j]
        sub_sum[i+1][ord(c) - ord('a')] += 1
    total_sum = [0] * 26
    for pos in p:
        for j in range(26):
            total_sum[j] += sub_sum[pos][j]
    for c in s:
        total_sum[ord(c) - ord('a')] += 1
    print(' '.join([str(t) for t in total_sum]))
