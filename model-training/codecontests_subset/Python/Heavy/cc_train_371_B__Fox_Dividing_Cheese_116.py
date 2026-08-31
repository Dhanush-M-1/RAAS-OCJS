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

def gcd(a, b):
    while b:
        a %= b
        a, b = b, a
    return a

def factorize(n):
    factors = []
    i = 2
    while i*i <= n:
        while n % i == 0:
            factors.append(i)
            n //= i
        i += 1
    if n > 1:
        factors.append(n)
    return factors

def main():
    n, m = mi(line())
    k = gcd(n, m)
    a = factorize(n // k)
    b = factorize(m // k)
    
    for f in a:
        if f not in (3, 5, 2):
            print(-1)
            return
    for f in b:
        if f not in (3, 5, 2):
            print(-1)
            return
    print(len(a) + len(b))
main()
