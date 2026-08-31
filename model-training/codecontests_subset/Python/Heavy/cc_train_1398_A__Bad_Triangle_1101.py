#!/usr/bin/env python
import os
import re
import sys
from bisect import bisect, bisect_left, insort, insort_left
from collections import Counter, defaultdict, deque
from copy import deepcopy
from decimal import Decimal
from fractions import gcd
from io import BytesIO, IOBase
from itertools import (
    accumulate, combinations, combinations_with_replacement, groupby,
    permutations, product)
from math import (
    acos, asin, atan, ceil, cos, degrees, factorial, hypot, log2, pi, radians,
    sin, sqrt, tan)
from operator import itemgetter, mul
from string import ascii_lowercase, ascii_uppercase, digits


def inp():
    return(int(input()))


def inlist():
    return(list(map(int, input().split())))


def instr():
    s = input()
    return(list(s[:len(s)]))


def invr():
    return(map(int, input().split()))


def main():
    t = inp()
    for _ in range(t):
        n = inp()
        d = inlist()
        a = d[0]
        b = d[1]
        c = d[-1]

        if a + b > c and a + c > b and b + c > a:
            print(-1)
        else:
            print(1, 2, n)



if __name__ == "__main__":
    main()
