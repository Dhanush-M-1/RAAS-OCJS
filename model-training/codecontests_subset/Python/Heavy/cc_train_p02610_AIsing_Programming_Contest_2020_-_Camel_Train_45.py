#!/usr/bin/env python3

import sys
import math
from bisect import bisect_right as br
from bisect import bisect_left as bl
sys.setrecursionlimit(2147483647)
from heapq import heappush, heappop,heappushpop
from collections import defaultdict
from itertools import accumulate
from collections import Counter
from collections import deque
from operator import itemgetter
from itertools import permutations
mod = 10**9 + 7
inf = float('inf')
def I(): return int(sys.stdin.readline())
def LI(): return list(map(int,sys.stdin.readline().split()))

t = I()
for _ in range(t):
    n = I()
    klr = [LI() for _ in range(n)]
    ans = 0
    L = []
    R = []
    for k,l,r in klr:
        if l >= r:
            L.append([k, l-r])
        else:
            R.append([n-k, r-l])
        ans += min(l, r)
    L.sort()
    R.sort()
    hl = []
    hr = []
    cnt = 0
    for k, x in L:
        heappush(hl, x)
        cnt += 1
        if cnt > k:
            heappop(hl)
            cnt -= 1
    cnt = 0
    for k, x in R:
        heappush(hr, x)
        cnt += 1
        if cnt > k:
            heappop(hr)
            cnt -= 1
    ans += sum(hl) + sum(hr)
    print(ans)