import sys, math
input = sys.stdin.readline

def getInts():
    return [int(s) for s in input().split()]

def getInt():
    return int(input())

def getStrs():
    return [s for s in input().split()]

def getStr():
    return input().strip()

def listStr():
    return list(input().strip())

import collections as col
import math

def solve():
    N = getInt()
    ans = 0
    while N > 1:
        if N % 3 != 0:
            return -1
        if N % 2 != 0:
            ans += 1
            N *= 2
        ans += 1
        N //= 6
    return ans


    
for _ in range(getInt()):
    print(solve())
    

