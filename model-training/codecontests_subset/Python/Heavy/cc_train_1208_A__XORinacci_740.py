"""
~~ Author : Bhaskar
~~ Dated : 08~06~2020
"""

import sys
from bisect import *
from math import floor,sqrt,ceil,factorial as F,gcd,pi
from itertools import chain,combinations,permutations,accumulate
from collections import Counter,defaultdict,OrderedDict,deque
from array import array
INT_MAX = sys.maxsize
INT_MIN = -(sys.maxsize)-1
mod = 1000000007
ch = "abcdefghijklmnopqrstuvwxyz"
lcm = lambda a,b : (a*b)//gcd(a,b)
setbit = lambda x : bin(x)[2:].count("1")
input = lambda : sys.stdin.readline()

def solve():
    T = int(input())
    for _ in range(T):
        a,b,n = map(int,input().split())
        x = [a,b,a^b]
        n = n%3
        print(x[n])


if __name__ == "__main__":
    try:
        sys.stdin = open("input.txt","r")
    except:
        pass
    solve()

