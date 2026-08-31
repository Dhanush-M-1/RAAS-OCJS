from array import array
from sys import stdin
import bisect
from bisect import *
import itertools
from itertools import *

def scan_gen():
    for line in stdin: yield from iter(line.split())
scan = scan_gen()
def nint(): return int(next(scan))
def nintk(k): return tuple(nint() for _ in range(k))
def nfloat(): return float(next(scan))
def intar_init(size): return array('i',[0]) *size
def intar(size=None):
    if size == None: size = nint()
    arr = intar_init(size) 
    for x in range(size): arr[x]=nint()
    return arr


def solve():
    n,k=nintk(2)
    A = sorted(intar(n))
    res =0
    for x in A:
        p = bisect_left(A,x+1)
        if p <n and A[p] <= x+k:
            res+=1
    print(n-res)

solve()

