import math
import time
import sys
import os
from math import gcd, floor, sqrt, log
start_time = time.time()
def iin(): return int(input())
def sin(): return input().strip()
def listin(): return list(map(int, input().strip().split()))
def liststr(): return list(map(str, input().strip().split()))
def ceill(x): return int(x) if(x == int(x)) else int(x)+1
def ceilldiv(x, d): x//d if(x % d == 0) else x//d+1
def LCM(a, b): return (a*b)//gcd(a, b)


def solve():
    a, b, c = listin()
    if a == 0:
        if b == 0:
            if c == 0:
                print(-1)
                return
            print(0)
            return
        print(1)

        print("{0:.10f}".format((-1*c)/b))
        return
    d = b**2 - (4*a*c)
    if d < 0:
        print(0)
        return
    x = set()
    x.add(((-1*b)-sqrt(d))/(2*a))
    x.add(((-1*b)+sqrt(d))/(2*a))
    x = list(x)
    x.sort()
    print(len(x))
    for i in x:
        print("{0:.10f}".format(i))


t = 1
# t = int(input())
for hula in range(t):
    solve()
sys.stderr.write(str(time.time()-start_time))
