#!/bin/python3

import math
import os
import random
import re
import sys
import heapq

n, k = map(int,input().split())
a = []
b = []
ab = []

for _ in range(n):
    t, av, bv = map(int, input().split())
    if av == 1 and bv == 1:
        #heapq.heappush(ab, t)
        ab.append(t)
    elif av == 1:
        #heapq.heappush(a, t)
        a.append(t)
    elif bv == 1:
        #heapq.heappush(b, t)
        b.append(t)

a = sorted(a, reverse=True)
b = sorted(b, reverse=True)
ab = sorted(ab, reverse=True)

ans = 0
infi = 10**5
possible = True
for _ in range(k):
    if (len(ab) == 0) and (len(a) == 0 or len(b) == 0):
        possible = False
        break
    at = a[-1] if len(a) > 0 else infi
    bt = b[-1] if len(b) > 0 else infi
    abt = ab[-1] if len(ab) > 0 else infi
    if (at+ bt) < abt:
        ans += (at+bt)
        a.pop()
        b.pop()
    else:
        ans += abt
        ab.pop()
if possible:
    print(ans)
else:
    print(-1)
