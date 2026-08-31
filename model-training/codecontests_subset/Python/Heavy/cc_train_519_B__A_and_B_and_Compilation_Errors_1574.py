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
# sys.stdin = open('input.txt', 'r')

# Printing the Output to output.txt file
# sys.stdout = open('output.txt', 'w')


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


n = inp()
a = inlist()
b = inlist()
c = inlist()
res = []
mark1 = defaultdict(def_value)
mark2 = defaultdict(def_value)
mark3 = defaultdict(def_value)

for i in c:
    mark3[i] += 1

for i in b:
    mark2[i] += 1
for k in mark2:
    if mark3[k] < mark2[k]:
        res.append(k)
        break
for i in a:
    mark1[i] += 1
for k in mark1:
    if mark2[k] < mark1[k]:
        res.append(k)
        break
for i in res[::-1]:
    print(i)
