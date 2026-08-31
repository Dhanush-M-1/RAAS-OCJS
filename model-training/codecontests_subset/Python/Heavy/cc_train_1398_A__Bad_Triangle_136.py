import sys
import string
import math
from collections import defaultdict
from functools import lru_cache
from collections import Counter
from fractions import Fraction

def mi(s):
    return map(int, s.strip().split())

def lmi(s):
    return list(mi(s))

def tmi(s):
    return tuple(mi(s))

def mf(f, s):
    return map(f, s)

def lmf(f, s):
    return list(mf(f, s))

def js(lst):
    return " ".join(str(d) for d in lst)

def jsns(lst):
    return "".join(str(d) for d in lst)

def line():
    return sys.stdin.readline().strip()

def linesp():
    return line().split()

def iline():
    return int(line())

def mat(n):
    matr = []
    for _ in range(n):
        matr.append(linesp())
    return matr

def matns(n):
    mat = []
    for _ in range(n):
        mat.append([c for c in line()])
    return mat

def mati(n):
    mat = []
    for _ in range(n):
       mat.append(lmi(line())) 
    return mat

def pmat(mat):
    for row in mat:
        print(js(row))

def solve(arr):
    arr = list(enumerate(arr))
    arr.sort(key=lambda x: x[1])

    i1, val1 = arr[-1]
    i2, val2 = arr[0]
    i3, val3 = arr[1]

    if val2 + val3 <= val1:
        x = min(i1, i2, i3)
        rest = [jj for jj in [i1, i2, i3] if jj != x]
        print(x + 1, min(rest) + 1, max(rest) + 1)
    else:
        print(-1)

def main():
    t = iline()

    for _ in range(t):
        line()
        arr = lmi(line())
        solve(arr)
main()
