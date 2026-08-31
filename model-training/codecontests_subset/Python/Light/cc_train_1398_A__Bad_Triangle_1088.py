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
    A = rl()
    L = [[a, i + 1] for i, a in enumerate(A)]
    L.sort()
    if L[0][0] + L[1][0] <= L[-1][0]:
        print (L[0][1], L[1][1], L[-1][1])
    else:
        print (-1)






mode = 'T'

if mode == 'T':
    t = ri()
    for i in range(t):
        solve()
else:
    solve()
