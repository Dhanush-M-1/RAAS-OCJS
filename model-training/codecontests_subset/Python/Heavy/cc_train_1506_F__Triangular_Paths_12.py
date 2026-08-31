from collections import defaultdict, deque, Counter
from heapq import heapify, heappop, heappush
import math
from copy import deepcopy
from itertools import combinations, permutations, product
from bisect import bisect_left, bisect_right

import sys
def input():
    return sys.stdin.readline().rstrip()
def getN():
    return int(input())
def getNM():
    return map(int, input().split())
def getList():
    return list(map(int, input().split()))
def getArray(intn):
    return [int(input()) for i in range(intn)]

mod = 10 ** 9 + 7
MOD = 998244353
INF = float('inf')
eps = 10 ** (-10)
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

#############
# Main Code #
#############

T = getN()
for _ in range(T):
    N = getN()
    R = [1] + getList()
    C = [1] + getList()
    P = [[r, c] for r, c in zip(R, C)]
    P.sort()

    ans = 0
    for i in range(N):
        diff1 = P[i][0] - P[i][1]
        diff2 = P[i + 1][0] - P[i + 1][1]
        # how many times do you select right edges
        if diff1 == diff2 and diff1 % 2 == 0:
            ans += (P[i + 1][1] - P[i][1])
            continue
        # if you are to go the same group, you don't pay for it.
        g_a = diff1 // 2
        g_b = diff2 // 2
        ans += g_b - g_a
    print(ans)