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

def solve(A, B):
    inter = set(A) & set(B)
    if inter:
        print("YES")
        print(1, list(inter)[0])
    else:
        print("NO")

def main():
    t = iline()
    for _ in range(t):
        line()
        arr = lmi(line())
        arr1 = lmi(line())
        solve(arr, arr1)

main()
