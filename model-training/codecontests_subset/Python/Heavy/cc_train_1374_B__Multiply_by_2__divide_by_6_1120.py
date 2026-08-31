import operator as op
import re
import sys
from bisect import bisect, bisect_left, insort, insort_left
from collections import Counter, defaultdict, deque
from copy import deepcopy
from decimal import Decimal
from functools import reduce
from itertools import (
    accumulate, combinations, combinations_with_replacement, groupby,
    permutations, product)
from math import (acos, asin, atan, ceil, cos, degrees, factorial, gcd, hypot,
                  log2, pi, radians, sin, sqrt, tan)
from operator import itemgetter, mul
from string import ascii_lowercase, ascii_uppercase, digits

# For getting input from input.txt file
#sys.stdin = open('input.txt', 'r')

# Printing the Output to output.txt file
#sys.stdout = open('output.txt', 'w')


def inp():
    return(int(input()))


def inlist():
    return(list(map(int, input().split())))


def instr():
    s = input()
    return(list(s[:len(s)]))


def invr():
    return(map(int, input().split()))


def def_value():
    return 0


t = inp()
for _ in range(t):
    res = 0
    n = inp()
    while n > 1:
        if n % 6 == 0:
            n //= 6
        elif n % 3 == 0:
            n *= 2
        else:
            res = -1
            break
        res += 1
    print(res)
