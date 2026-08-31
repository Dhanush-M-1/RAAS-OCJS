import os
from io import BytesIO, IOBase
import sys
from collections import defaultdict,deque,Counter
from bisect import *
from math import sqrt,pi,ceil
import math
from itertools import permutations
from copy import deepcopy

for t in range(int(input())):
    n = int(input())
    a = []
    for i in range(n):
        a.append(list(input().rstrip()))
    f = [a[n - 1][-2], a[n - 2][-1]]
    s = [a[0][1], a[1][0]]
    if f[0] == "0" and f[1] == "0":
        if s[0] == "1" and s[1] == "1":
            print(0)
        elif s[0] == "1" and s[1] == "0":
            print(1)
            print(2, 1)
        elif s[0] == "0" and s[1] == "0":
            print(2)
            print(1, 2)
            print(2, 1)
        else:
            print(1)
            print(1, 2)
    elif f[0] == "1" and f[1] == "1":
        if s[0] == "1" and s[1] == "1":
            print(2)
            print(1, 2)
            print(2, 1)
        elif s[0] == "1" and s[1] == "0":
            print(1)
            print(1, 2)
        elif s[0] == "0" and s[1] == "1":
            print(1)
            print(2, 1)
        else:
            print(0)
    elif f[0] == "1" and f[1] == "0":
        if s[0] == "1" and s[1] == "1":
            print(1)
            print(n, n - 1)
        elif s[0] == "1" and s[1] == "0":
            print(2)
            print(2, 1)
            print(n, n - 1)
        elif s[0] == "0" and s[1] == "1":
            print(2)
            print(2, 1)
            print(n - 1, n)
        else:
            print(1)
            print(n - 1, n)
    else:
        if s[0] == "1" and s[1] == "1":
            print(1)
            print(n - 1, n)
        elif s[0] == "1" and s[1] == "0":
            print(2)
            print(2, 1)
            print(n - 1, n)
        elif s[0] == "0" and s[1] == "1":
            print(2)
            print(2, 1)
            print(n, n - 1)
        else:
            print(1)
            print(n, n - 1)
