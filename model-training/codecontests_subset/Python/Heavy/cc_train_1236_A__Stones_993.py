import itertools
import math
import sys
import heapq
from collections import Counter
from collections import deque
from fractions import gcd
from functools import reduce

sys.setrecursionlimit(4100000)
INF = 1 << 60
MOD = 10 ** 9 + 7

# ここから書き始める
t = int(input())
for i in range(t):
    a1, b1, c1 = map(int, input().split())
    a2, b2, c2 = a1, b1, c1
    cnt1 = min(a1, b1 // 2)
    ans1 = cnt1 * 3
    b1 -= cnt1 * 2
    cnt2 = min(b1, c1 // 2)
    ans1 += cnt2 * 3
    # print(ans1)
    # a2, b2, c2 = a1, b1, c1
    cnt3 = min(b2, c2 // 2)
    # print("k = %d, cnt3 = %d, a2 = %d, b2 = %d, c2 = %d" % (t, cnt3, a2, b2, c2))
    ans2 = cnt3 * 3
    b2 -= cnt3
    cnt4 = min(a2, b2 // 2)
    ans2 += cnt4 * 3
    print(max(ans1, ans2))
    # while True:

