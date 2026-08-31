# -*- coding: utf-8 -*-
import sys
from collections import defaultdict, deque
from math import sqrt, gcd
def input(): return sys.stdin.readline()[:-1]
# def input(): return sys.stdin.buffer.readline()[:-1]

n = int(input())
a = [int(x) for x in input().split()]

mx = max(a)
a = [mx - x for x in a if mx - x != 0]

z = a[0]

for e in a:
  z = gcd(e, z)

y = 0

for e in a:
  y += e // z

print(y, z)






"""
ab bc / ac = bb

  a  b  c  d
a *  ab ac ad
b ab *  bc bd
c ac bc    cd
d ad bd cd

4 2 
3
2 3 4

  2 3 4
2   6 8
3 6   12
4 8 12 

"""

