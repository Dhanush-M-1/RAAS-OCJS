# python3

#===============================================================================
from collections import defaultdict, Counter
from functools import lru_cache
from heapq import heappush, heappop
from math import gcd, floor, ceil
from sys import stdin, stdout

def ilist():
    return [int(x) for x in stdin.readline().strip().split(" ")]
def iint():
    return int(stdin.readline().strip())
def istr():
    return stdin.readline().strip()
#===============================================================================


def solve(a):
    n = len(a)
    res = set()
    for i in range(n):
        res.add((i+a[i])%n)
    if len(res) == n:
        return "YES"
    return "NO"


if __name__ == '__main__':
    t = iint()
    for _ in range(t):
        n = iint()
        a = ilist()
        print(solve(a))
