from collections import Counter
from collections import deque
from sys import stdin
from bisect import *
from heapq import *
import math

g   = lambda : stdin.readline().strip()
gl  = lambda : g().split()
gil = lambda : [int(var) for var in gl()]
gfl = lambda : [float(var) for var in gl()]
gcl = lambda : list(g())
gbs = lambda : [int(var) for var in g()]
mod = int(1e9)+7
inf = float("inf")


n, k = gil()
a, b, c = [0], [0], [0]
for _ in range(n):
    bk = gil()
    if bk[1]&bk[2]:
        c.append(bk[0])
    elif bk[1]:
        a.append(bk[0])
    elif bk[2]:
        b.append(bk[0])

a.sort(); b.sort(); c.sort()
# print(a, b, c)

for lst in (a, b, c):
    for i in range(2, len(lst)):
        lst[i] += lst[i-1]

ans = inf; lmt = len(min(a, b,key=len))
# print(lmt)

for i in range(min(len(c), k+1)):
    j = k - i 
    # print(i, j)
    if 0 <= j < lmt:
        ans = min(c[i] + a[j] + b[j], ans)

print(ans if ans != inf else -1)
