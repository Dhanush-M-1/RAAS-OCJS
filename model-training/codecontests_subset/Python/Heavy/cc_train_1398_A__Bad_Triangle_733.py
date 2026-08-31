import sys
import random
from fractions import Fraction
from math import *
 
def input():
    return sys.stdin.readline().strip()
 
def iinput():
    return int(input())

def finput():
    return float(input())

def tinput():
    return input().split()

def linput():
    return list(input())
 
def rinput():
    return map(int, tinput())

def fiinput():
    return map(float, tinput())

def flinput():
    return list(fiinput())
 
def rlinput():
    return list(map(int, input().split()))
def trinput():
    return tuple(rinput())

def srlinput():
    return sorted(list(map(int, input().split())))

def NOYES(fl):
    if fl:
        print("NO")
    else:
        print("YES")
def YESNO(fl):
    if fl:
        print("YES")
    else:
        print("NO")
    
def main():
    n = iinput()
    q = rlinput()
    m2 = q.index(max(q))
    mm2 = max(q)
    m = q.index(min(q))
    mm1 = min(q)
    del q[m]
    m1 = q.index(min(q))
    if m1 >= m:
        m1 += 1
    q.sort()
    if mm1 + min(q) <= mm2:
        print(*sorted([m + 1, m1 + 1, m2 + 1]))
    else:
        print(-1)
    
for TESTING in range(iinput()):
    main()
