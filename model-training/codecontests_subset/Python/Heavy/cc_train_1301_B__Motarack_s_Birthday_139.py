import sys, math
reader = (line.rstrip() for line in sys.stdin)
input = reader.__next__

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
    A = getInts()
    
    # _ _ 7 _ 3 _ 5 _ 11
    # we need to know: the max difference already in existence; ceil((max-min)//2)
    # worst case: halfway between max and min of array
    max_A = -10**18
    min_A = 10**18
    if A == [-1]*N:
        print(0,0)
        return
    for i in range(N):
        if i > 0 and A[i-1] == -1 and A[i] != -1:
            max_A = max(max_A,A[i])
            min_A = min(min_A,A[i])
        if i < N-1 and A[i+1] == -1 and A[i] != -1:
            max_A = max(max_A,A[i])
            min_A = min(min_A,A[i])
    targ = (max_A+min_A)//2
    for i in range(N):
        if A[i] == -1:
            A[i] = targ
    ans = 0
    for i in range(N-1):
        ans = max(ans,abs(A[i+1]-A[i]))
    print(ans,targ)
    return

for t in range(getInt()):
    solve()
    

