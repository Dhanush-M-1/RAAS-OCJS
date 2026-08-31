from collections import defaultdict as dd
from collections import deque
import bisect
import heapq

def ri():
    return int(input())

def rl():
    return list(map(int, input().split()))


def solve():
    n = ri()
    fail = False
    p, c = rl()
    if c > p:
        fail = True
    for i in range(n - 1):
        np, nc = rl()
        if np < p or nc < c:
            fail = True
        if nc > np:
            fail = True
        if nc - c > np - p:
            fail = True
        p, c = np, nc

    if fail:
        print ("NO")
    else:
        print ("YES")






mode = 'T'

if mode == 'T':
    t = ri()
    for i in range(t):
        solve()
else:
    solve()
