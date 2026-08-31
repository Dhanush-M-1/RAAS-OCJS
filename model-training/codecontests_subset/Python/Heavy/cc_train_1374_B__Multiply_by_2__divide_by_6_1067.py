from sys import stdin
from collections import defaultdict as dd
from collections import deque as dq
import itertools as it
from math import sqrt, log, log2
from fractions import Fraction

t = int(input())
for _ in range(t):
    n  = int(input())
    seen = set()
    nummoves = 0
    flag = 0
    while n!=1:
        if n in seen or n%3!=0:
            flag = 1
            break
        seen.add(n)
        if n%6 == 0:
            n //= 6
        else:
            n*=2
        nummoves += 1
    

    if flag: print(-1)
    else: print(nummoves)