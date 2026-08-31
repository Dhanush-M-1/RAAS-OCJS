# aadiupadhyay
import os.path
from math import gcd, floor, ceil
from collections import *
import sys
mod = 1000000007
INF = float('inf')
def st(): return list(sys.stdin.readline().strip())
def li(): return list(map(int, sys.stdin.readline().split()))
def mp(): return map(int, sys.stdin.readline().split())
def inp(): return int(sys.stdin.readline())
def pr(n): return sys.stdout.write(str(n)+"\n")
def prl(n): return sys.stdout.write(str(n)+" ")


if os.path.exists('input.txt'):
    sys.stdin = open('input.txt', 'r')
    sys.stdout = open('output.txt', 'w')

# only pypy3 passed

def solve():
    n, m = mp()
    ans = []
    l = li()
    d = Counter(l)
    for i in range(m):
        x = inp()
        copy_d = dict(d)
        cur = 1
        while (cur << 1) <= x:
            cur <<= 1
        now = 0
        while cur > 0:
            have = copy_d.get(cur, 0)
            can_fit = x//cur
            mi = min(have, can_fit)
            x -= mi * cur
            now += mi
            cur >>= 1
        if x == 0:
            ans.append(now)
        else:
            ans.append(-1)
    print(*ans, sep='\n')


for _ in range(1):
    solve()
