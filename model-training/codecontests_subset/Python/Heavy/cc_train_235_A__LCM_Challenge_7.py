import sys, math
input = sys.stdin.readline

def getInts():
    return [int(s) for s in input().split()]

def getInt():
    return int(input())

def getStrs():
    return [s for s in input().split()]

def getStr():
    return input()

def listStr():
    return list(input())

import collections as col
import math

def solve():
    N = getInt()
    if N == 1:
        return 1
    if N == 2:
        return 2
    if N % 2 == 1:
        return N*(N-1)*(N-2)
    return max(N*(N-1)*(N-2)//2,(N-1)*(N-2)*(N-3), N*(N-1)*(N-3) if N % 3 > 0 else 0)
    #can we make a bigger number using N? N*(N-1), we can't use (N-2), we could use N-3

print(solve())
    

