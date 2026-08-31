import bisect
import sys
import math
input = sys.stdin.readline
import functools
import heapq

from collections import defaultdict

############ ---- Input Functions ---- ############

def inp():
    return(int(input()))
def inlt():
    return(list(map(int,input().split())))
def insr():
    s = input()
    return(list(s[:len(s) - 1]))
def invr():
    return(map(int,input().split()))

############ ---- Solution ---- ############

def solve():
    [n, k] = inlt()
    bks = []
    for i in range(n):
        [t, a, b] = inlt()
        bks.append((t, a, b))

    bks.sort(key=lambda x: x[0])

    aa = [v for v in bks if v[1] == 1 and v[2] == 0][:k]
    bb = [v for v in bks if v[1] == 0 and v[2] == 1][:k]
    com = [v for v in bks if v[1] == 1 and v[2] == 1][:k]

    com_picked = []

    for b in com:
        acount = len(aa) + len(com_picked)
        bcount = len(bb) + len(com_picked)
        if acount < k or bcount < k or b[0] < (aa[-1][0] + bb[-1][0]):
            com_picked.append(b)
            if acount >= k:
                aa.pop()
            if bcount >= k:
                bb.pop()

    acount = len(aa) + len(com_picked)
    bcount = len(bb) + len(com_picked)    
    if acount < k or bcount < k:
        return -1

    res = 0
    res += sum(t for t, _, _ in aa)
    res += sum(t for t, _, _ in bb)
    res += sum(t for t, _, _ in com_picked)
    
    return res
    

if len(sys.argv) > 1 and sys.argv[1].startswith("input"):
    f = open("./" + sys.argv[1], 'r')
    input = f.readline

res = solve()
print(str(res))
