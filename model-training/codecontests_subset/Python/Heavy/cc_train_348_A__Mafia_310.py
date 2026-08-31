import sys, heapq as h
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

"""
Least demanding player hosts until he is no longer the least demanding:
[9,8,5,4,1]
[5,4,1,1,0] 4 rounds
he can now host all remaining rounds
in fact, if the two smallest values S1+S2 <= SN the biggest value, S1 can host S2 rounds, S2 can host SN-S2 rounds, SN-S2 >= S1 so everyone is happy

What about if S1+S2 > N, i.e. they cannot do it alone?
From the position where everyone N people each require K rounds, we must decrease the number by N*K, N-1 at a time, so ceil(N*K/(N-1))
[12,11,10,9,6]
[9,8,7,6,6]

We can extend this logic: N-1 reductions required each time, so ceil(sum(A)/(N-1))

"""

def solve():
    N = getInt()
    A = getInts()
    return max(math.ceil(sum(A)/(N-1)),max(A))
    
#for _ in range(getInt()):
#    print(solve())
print(solve())
    