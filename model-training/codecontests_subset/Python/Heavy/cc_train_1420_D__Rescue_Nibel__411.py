#!/usr/bin/env python3

import sys
import math
mod = 998244353
inf = float('inf')
from collections import defaultdict
def I(): return int(sys.stdin.readline())
def LI(): return list(map(int,sys.stdin.readline().split()))

class BinaryIndexedTree:
    def __init__(self, size):
        self.bit = [0 for _ in range(size)]
        self.size = size
 
    def add(self, i, w):
        x = i + 1
        while x <= self.size:
            self.bit[x - 1] += w
            x += x & -x
        return
 
    def sum(self, i):
        res = 0
        x = i + 1
        while x > 0:
            res += self.bit[x - 1]
            x -= x & -x
        return res

def comb(n, r):
    return fact[n]*inv[n-r]*inv[r] % mod

n, k = LI()
lr = [LI() for _ in range(n)]
fact = [1] * (n+1)
inv = [1] * (n+1)
for i in range(1, n+1):
    fact[i] = i*fact[i-1]
    fact[i] %= mod
    inv[i] = pow(i, mod-2, mod) * pow(fact[i-1], mod-2, mod)
    inv[i] %= mod

lst = []
for l, r in lr:
    lst.append(2*l)
    lst.append(2*r+1)
lst.sort()
tmp = 0
ans = 0
for i in lst:
    if i % 2:
        tmp -= 1
    else:
        if tmp >= k-1:
            ans += comb(tmp, k-1)
            ans %= mod
        tmp += 1
print(ans)
