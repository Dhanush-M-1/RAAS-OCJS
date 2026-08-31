#!/usr/bin/python3

import array
import bisect
import math
import os
import random
import re
import sys
from typing import List, Any

sys.setrecursionlimit(10000)

INIT = -1
INF = 10**18

n: int
k: int
a: List[int]
pre: List[int]

def printf(format: str, *args):
  sys.stdout.write(format % args)


def lo(l: int, r: int, x: int) -> int:
  """Determines cost to increase [l,r) to x."""
  if r <= l:
    return 0
  cnt = r - l
  got = pre[r - 1]
  want = x * cnt + l * (x - 1)
  return want - got


def hi(l: int, r: int, x: int) -> int:
  """Determines cost to reduce [l,r) to x."""
  if r <= l:
    return 0
  cnt = r - l
  got = pre[n - 1]
  if l > 0:
    got -= pre[l - 1]
  want = cnt * x + (n - r) * (x + 1)
  return got - want


def main():
  global n, k, a, pre
  [n, k] = list(map(int, input().strip().split(' ')))
  a = list(map(int, input().strip().split(' ')))

  a.sort()
  pre = array.array('q', [0]) * n
  
  for i in range(n):
    if i > 0:
      pre[i] = pre[i - 1]
    pre[i] += a[i]

  ans = INF
  for i in range(n):
    x = a[i]
    l = bisect.bisect_left(a, x, 0, i)  # left extent of x
    r = bisect.bisect_right(a, x, i, n)  # upper bound of x, exclusive

    lgot = i - l
    rgot = r - i
    got = lgot + rgot
    if got >= k:
      ans = 0
      break

    # case 1: min before max
    lneed = k - got
    lcost = 0
    lcan = min(l, lneed)
    lneed -= lcan
    lcost = lo(l - lcan, l, x)
    if lneed > 0:
      lcost += hi(r, r + lneed, x)
    ans = min(ans, lcost)
    
    # case 2: max before min
    rneed = k - got
    rcan = min(n - r, rneed)
    rneed -= rcan
    rcost = hi(r, r + rcan, x)
    if rneed > 0:
      rcost += lo(l - rneed, l, x)
    ans = min(ans, rcost)

  print(ans)

  
if __name__ == '__main__':
  main()
